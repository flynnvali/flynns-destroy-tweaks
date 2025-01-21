package net.flynnvali.fdtweaks.chemistry.legacy.index;
import com.petrolpark.destroy.chemistry.legacy.LegacyReaction;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;


import com.simibubi.create.AllTags;


import net.flynnvali.fdtweaks.FDTweaks;





public class FDTweaksReactions {
    public static final LegacyReaction


    FRIEDAL_CRAFT_ALKYLATION = builder()
            .id("friedal_craft_alkylation")
            .addReactant(FDTweaksMolecules.METHYL_CHLORIDE)
            .addReactant(DestroyMolecules.BENZENE)
            .addCatalyst(DestroyMolecules.IRON_III, 1)
            .addCatalyst(DestroyMolecules.CHLORIDE, 1)
            .addProduct(DestroyMolecules.TOLUENE)
            .addProduct(DestroyMolecules.HYDROCHLORIC_ACID)
            .build(),

            SABATIER_PROCESS = builder()
            .id("sabatier_process")
            .addReactant(DestroyMolecules.HYDROGEN, 4)
            .addReactant(DestroyMolecules.CARBON_DIOXIDE)
            .addSimpleItemTagCatalyst(AllTags.forgeItemTag("dusts/nickel"), 1f)
            .addProduct(DestroyMolecules.METHANE)
            .addProduct(DestroyMolecules.WATER, 2)
            .activationEnergy(50f)
            .build(),

            METHANE_CHLORINATION = builder()
            .id("methane_chlorination")
            .addReactant(DestroyMolecules.METHANE)
            .addReactant(DestroyMolecules.CHLORINE)
            .addProduct(FDTweaksMolecules.METHYL_CHLORIDE)
            .addProduct(DestroyMolecules.HYDROCHLORIC_ACID)
            .requireUV()
            .build(),


            METHANOL_HYDROCHLORINATION = builder()
            .id("methanol_hydrochlorination")
            .addReactant(DestroyMolecules.METHANOL)
            .addReactant(DestroyMolecules.HYDROCHLORIC_ACID)
            .addProduct(FDTweaksMolecules.METHYL_CHLORIDE)
            .addProduct(DestroyMolecules.WATER)
            .requireUV()
            .build(),

    METHYL_CHLORIDE_CHLORINATION = builder()
            .id("methyl_chloride_chlorination")
            .addReactant(FDTweaksMolecules.METHYL_CHLORIDE)
            .addReactant(DestroyMolecules.CHLORINE)
            .addProduct(FDTweaksMolecules.DICHLOROMETHANE)
            .addProduct(DestroyMolecules.HYDROCHLORIC_ACID)
            .requireUV()
            .build(),

    DCM_CHLORINATION = builder()
            .id("dcm_chlorination")
            .addReactant(FDTweaksMolecules.DICHLOROMETHANE)
            .addReactant(DestroyMolecules.CHLORINE)
            .addProduct(DestroyMolecules.CHLOROFORM)
            .addProduct(DestroyMolecules.HYDROCHLORIC_ACID)
            .requireUV()
            .build(),

    CHLOROFORM_CHLORINATION = builder()
            .id("chloroform_chlorination")
            .addReactant(DestroyMolecules.CHLOROFORM)
            .addReactant(DestroyMolecules.CHLORINE)
            .addProduct(DestroyMolecules.CARBON_TETRACHLORIDE)
            .addProduct(DestroyMolecules.HYDROCHLORIC_ACID)
            .requireUV()
            .build(),





    CYANIDE_NEUTRALIZATION = builder()
            .id("cyanide_neutralization")
            .addReactant(DestroyMolecules.HYDROGEN_CYANIDE)
            .addReactant(DestroyMolecules.HYDROXIDE)
            .addProduct(DestroyMolecules.WATER)
            .addProduct(DestroyMolecules.CYANIDE)
            .build(),




    HYPOCHLOROUS_ACID_NEUTRALIZATION = builder()
           .id("hypochlorous_acid_neutralization")
           .addReactant(DestroyMolecules.HYPOCHLOROUS_ACID)
           .addReactant(DestroyMolecules.HYDROXIDE)
           .addProduct(DestroyMolecules.WATER)
           .addProduct(DestroyMolecules.HYPOCHLORITE)
           .build();




    private static LegacyReaction.ReactionBuilder builder() {
        return new LegacyReaction.ReactionBuilder(FDTweaks.MOD_ID);
    };
    public static void register() {};
}
