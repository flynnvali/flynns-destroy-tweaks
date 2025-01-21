package net.flynnvali.fdtweaks.chemistry.legacy.index;
import com.petrolpark.destroy.Destroy;
import com.petrolpark.destroy.chemistry.legacy.LegacyElement;
import com.petrolpark.destroy.chemistry.legacy.LegacyMolecularStructure;
import com.petrolpark.destroy.chemistry.legacy.LegacySpecies;
import com.petrolpark.destroy.chemistry.legacy.LegacySpeciesTag;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;
import net.flynnvali.fdtweaks.FDTweaks;


public class FDTweaksMolecules {

    public static final LegacySpecies
            METHYL_CHLORIDE = builder() // R-40
            .id("chloromethane")
            .structure(LegacyMolecularStructure.deserialize("destroy:linear:CCl"))
            .boilingPointInKelvins(249.3f)
            .density(1003f)
            .molarHeatCapacity(81.2f)
            .tag(DestroyMolecules.Tags.REFRIGERANT)
            .build(),

    DICHLOROMETHANE = builder() // DCM, R-30
            .id("dichloromethane")
            .structure(LegacyMolecularStructure.deserialize("destroy:linear:ClCCl"))
            .boilingPointInKelvins(312.8f)
            .density(1326.6f)
            .molarHeatCapacity(102.3f)
            .tag(DestroyMolecules.Tags.REFRIGERANT)
            .tag(DestroyMolecules.Tags.ACUTELY_TOXIC)
            .build();


    private static LegacySpecies.MoleculeBuilder builder() {
        return new LegacySpecies.MoleculeBuilder(FDTweaks.MOD_ID);




    };

    public static void register() {};



}
