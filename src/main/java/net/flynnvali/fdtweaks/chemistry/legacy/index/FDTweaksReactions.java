package net.flynnvali.fdtweaks.chemistry.legacy.index;
import com.petrolpark.destroy.chemistry.legacy.LegacyReaction;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;


import com.petrolpark.destroy.chemistry.legacy.reactionresult.PrecipitateReactionResult;
import com.petrolpark.destroy.config.DestroySubstancesConfigs;
import com.petrolpark.destroy.item.DestroyItems;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;


import net.flynnvali.fdtweaks.FDTweaks;
import net.flynnvali.fdtweaks.item.FDTweaksItems;


public class FDTweaksReactions {
    public static final LegacyReaction


        //    COPPER_ELECTROLYSIS = builder()
         //   .id("copper_electrolysis")
         //   .addReactant(DestroyMolecules.COPPER_II)
          //  .addReactant(DestroyMolecules.HYDROGEN)
          //  .addSimpleItemTagReactant(AllTags.forgeItemTag("dusts/iron"), 4.5f)
          //  .addSimpleItemCatalyst(FDTweaksItems.MYSTIC_ELECTRIC_SOURCE::get, 4.5f)
          //  .addProduct(DestroyMolecules.IRON_III)
          //  .addProduct(DestroyMolecules.PROTON, 2)
          //  .withResult(4.5f, PrecipitateReactionResult.of(DestroyItems.COPPER_POWDER::asStack))
          //  .build(),


    FRIEDAL_CRAFT_ALKYLATION = builder()
            .id("friedal_craft_alkylation")
            .addReactant(DestroyMolecules.CHLOROMETHANE)
            .addReactant(DestroyMolecules.BENZENE)
            .addCatalyst(DestroyMolecules.IRON_III, 1)
            .addCatalyst(DestroyMolecules.CHLORIDE, 1)
            .addProduct(DestroyMolecules.TOLUENE)
              .addProduct(DestroyMolecules.HYDROCHLORIC_ACID)
         .build(),




          METHANOL_HYDROCHLORINATION = builder()
           .id("methanol_hydrochlorination")
            .addReactant(DestroyMolecules.METHANOL)
            .addReactant(DestroyMolecules.HYDROCHLORIC_ACID)
            .addCatalyst(DestroyMolecules.ZINC_ION, 1)
            .addCatalyst(DestroyMolecules.CHLORIDE, 1)
            .addProduct(DestroyMolecules.CHLOROMETHANE)
            .addProduct(DestroyMolecules.WATER)
            .build(),          //
            Silver_DISSOLUTION = builder() //TODO replace with redox
            .id("silver_dissolution")
            .addReactant(DestroyMolecules.PROTON, 2, 1)
            .addSimpleItemTagReactant(AllTags.forgeItemTag("dusts/silver"), 8f)
            .addProduct(DestroyMolecules.HYDROGEN, 1)
            .addProduct(FDTweaksMolecules.SILVER, 2)
            .build(),
            SILVER_ORE_DISSOLUTION = builder()
                    .id("silver_ore_dissolution")
                    .addReactant(DestroyMolecules.PROTON, 2, 1)
                    .addSimpleItemReactant(AllItems.CRUSHED_SILVER::get, 16f)
                    .addProduct(DestroyMolecules.HYDROGEN, 1)
                    .addProduct(FDTweaksMolecules.SILVER, 2)
                    .build(),
            SILVER_OXIDIZATION = builder()
                    .id("silver_oxidization")
                    .addReactant(DestroyMolecules.HYDROXIDE, 2, 1)
                    .addReactant(FDTweaksMolecules.SILVER, 2, 1)
                    .addCatalyst(DestroyMolecules.SODIUM_ION, 1)
                    .addCatalyst(DestroyMolecules.NITRATE, 1)
                    .addProduct(DestroyMolecules.WATER, 1)
                    .addProduct(FDTweaksMolecules.SILVER_OXIDE, 1)
                    .build(),

             METHANOL_HYDROIODATION = builder()
            .id("methanol_hydroiodation")
            .addReactant(DestroyMolecules.METHANOL)
            .addReactant(DestroyMolecules.HYDROGEN_IODIDE)
            .addProduct(DestroyMolecules.IODOMETHANE)
            .addProduct(DestroyMolecules.WATER)
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
    
                HYDROGEN_CYANIDE_NEUTRALIZATION= builder()
            .id("hcn_neutralization")
            .addReactant(DestroyMolecules.HYDROGEN_CYANIDE)
            .addReactant(DestroyMolecules.HYDROXIDE)
            .addProduct(DestroyMolecules.CYANIDE)
            .addProduct(DestroyMolecules.WATER)
            .dontIncludeInJei()
            .build(),

            HYPOCHLOROUS_ACID_NEUTRALIZATION= builder()
            .id("hypochlorous_acid_neutralization")
            .addReactant(DestroyMolecules.HYPOCHLOROUS_ACID)
            .addReactant(DestroyMolecules.HYDROXIDE)
            .addProduct(DestroyMolecules.HYPOCHLORITE)
            .addProduct(DestroyMolecules.WATER)
            .dontIncludeInJei()
            .build();









    private static LegacyReaction.ReactionBuilder builder() {
        return new LegacyReaction.ReactionBuilder(FDTweaks.MOD_ID);
    };
    public static void register() {};
}
