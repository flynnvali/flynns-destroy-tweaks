package net.flynnvali.fdtweaks.chemistry.legacy.index.genericreaction;

import com.petrolpark.destroy.chemistry.legacy.*;
import com.petrolpark.destroy.chemistry.legacy.genericreaction.GenericReactant;
import com.petrolpark.destroy.chemistry.legacy.genericreaction.SingleGroupGenericReaction;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyGroupTypes;
import com.petrolpark.destroy.chemistry.legacy.index.genericreaction.HalideSubstitution;
import com.petrolpark.destroy.chemistry.legacy.index.group.AlcoholGroup;
import com.petrolpark.destroy.chemistry.legacy.index.group.NonTertiaryAmineGroup;
import com.petrolpark.destroy.chemistry.legacy.index.group.PrimaryAmineGroup;
import net.flynnvali.fdtweaks.FDTweaks;
import net.flynnvali.fdtweaks.chemistry.legacy.index.FDTweaksMolecules;
import com.petrolpark.destroy.Destroy;
import com.petrolpark.destroy.chemistry.legacy.genericreaction.SingleGroupGenericReaction;
import com.petrolpark.destroy.chemistry.legacy.LegacyReaction.ReactionBuilder;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;
import com.petrolpark.destroy.chemistry.legacy.index.group.NonTertiaryAmineGroup;

import java.util.List;

public class HofmannElimination extends SingleGroupGenericReaction<PrimaryAmineGroup> {

    public HofmannElimination() {
        super(Destroy.asResource("hofmann_elimination"), DestroyGroupTypes.PRIMARY_AMINE);
    };

    @Override
    public boolean isPossibleIn(ReadOnlyMixture mixture) {
        return mixture.getConcentrationOf(FDTweaksMolecules.SILVER_OXIDE) > 0f;
    };

    @Override
    public LegacyReaction generateReaction(GenericReactant<PrimaryAmineGroup> reactant) {
        LegacyMolecularStructure structure = reactant.getMolecule().shallowCopyStructure();
        PrimaryAmineGroup amineGroup = reactant.getGroup();

        ReactionBuilder builder = reactionBuilder();

        int products = 0;
        for (LegacyAtom carbon : structure.moveTo(amineGroup.carbon).getBondedAtomsOfElement(LegacyElement.CARBON)) {
            List<LegacyAtom> hydrogens = structure.moveTo(carbon).getBondedAtomsOfElement(LegacyElement.HYDROGEN);
            List<LegacyAtom> carbons = structure.getBondedAtomsOfElement(LegacyElement.CARBON);
            List<LegacyAtom> rGroups = structure.getBondedAtomsOfElement(LegacyElement.R_GROUP);
            if (rGroups.size() + hydrogens.size() + carbons.size() != 4 || hydrogens.size() == 0) continue; // Don't form from non-sp3 alkyl carbons
            LegacyMolecularStructure productStructure = structure.shallowCopy();
            productStructure
                    .remove(hydrogens.get(0))
                    .remove(amineGroup.nitrogen)
                    .remove(amineGroup.firstHydrogen)
                    .remove(amineGroup.secondHydrogen)
                    .moveTo(carbon)
                    .replaceBondTo(amineGroup.carbon, LegacyBond.BondType.DOUBLE);
            builder.addProduct(moleculeBuilder().structure(productStructure).build());
            products++;
        };

        if (products == 0) return null;

        builder
                .addReactant(reactant.getMolecule(), products)
                .addReactant(DestroyMolecules.IODOMETHANE, 3)
                .addReactant(FDTweaksMolecules.SILVER_OXIDE)
                .addProduct(DestroyMolecules.HYDROGEN_IODIDE)
                .addProduct(DestroyMolecules.IODIDE, 2)
                .addProduct(DestroyMolecules.WATER)
                .addProduct(FDTweaksMolecules.SILVER, 2)
                .addProduct(DestroyMolecules.TRIMETHYLAMINE);


        return builder.build();
    };

    @Override
    public LegacyReaction generateExampleReaction() {
        LegacyAtom carbon = new LegacyAtom(LegacyElement.CARBON);
        LegacyAtom nitrogen = new LegacyAtom(LegacyElement.NITROGEN);
        LegacyAtom firstHydrogen = new LegacyAtom(LegacyElement.HYDROGEN);
        LegacyAtom secondHydrogen = new LegacyAtom(LegacyElement.HYDROGEN);
        LegacyAtom r1 = new LegacyAtom(LegacyElement.R_GROUP);
        r1.rGroupNumber = 1;
        LegacyAtom r2 = new LegacyAtom(LegacyElement.R_GROUP);
        r2.rGroupNumber = 2;
        LegacyAtom r3 = new LegacyAtom(LegacyElement.R_GROUP);
        r3.rGroupNumber = 3;
        LegacyAtom r4 = new LegacyAtom(LegacyElement.R_GROUP);
        r4.rGroupNumber = 4;

        return generateReaction(
                new GenericReactant<PrimaryAmineGroup>(
                        moleculeBuilder().structure(
                                LegacyMolecularStructure.atom(LegacyElement.CARBON)
                                        .addAtom(LegacyElement.HYDROGEN)
                                        .addAtom(r1)
                                        .addAtom(r2)
                                        .addAtom(carbon)
                                        .moveTo(carbon)
                                        .addAtom(r3)
                                        .addAtom(r4)
                                        .addAtom(nitrogen)
                                        .moveTo(nitrogen)
                                        .addAtom(firstHydrogen)
                                        .addAtom(secondHydrogen)
                        ).build(),
                        new PrimaryAmineGroup(carbon, nitrogen , firstHydrogen, secondHydrogen)
                )
        );
    };
};
