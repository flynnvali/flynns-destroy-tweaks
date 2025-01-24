package net.flynnvali.fdtweaks.chemistry.legacy.index;
import com.petrolpark.destroy.Destroy;
import com.petrolpark.destroy.chemistry.legacy.LegacyMolecularStructure;
import com.petrolpark.destroy.chemistry.legacy.*;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;
import net.flynnvali.fdtweaks.FDTweaks;
import com.petrolpark.destroy.chemistry.legacy.LegacyBond.BondType;
import com.petrolpark.destroy.chemistry.legacy.LegacySpecies;


public class FDTweaksMolecules {

    public static final LegacySpecies


            SILVER = builder()
            .id("silver")
            .structure(LegacyMolecularStructure.atom(LegacyElement.PLATINUM, 1))
            .build(),


            SILVER_OXIDE = builder() // R-40
            .id("silver_oxide")
            .structure(LegacyMolecularStructure.atom(LegacyElement.OXYGEN)
                    .addAtom(LegacyElement.PLATINUM)
                    .addAtom(LegacyElement.PLATINUM)
            )
            .boilingPointInKelvins(573f)
            .density(7410f)
            .molarHeatCapacity(65.9f)
            .build();










    private static LegacySpecies.MoleculeBuilder builder() {
        return new LegacySpecies.MoleculeBuilder(FDTweaks.MOD_ID);




    };

    public static void register() {};



}
