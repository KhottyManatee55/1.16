package cofh.thermal.core.datagen;

import cofh.core.datagen.RecipeProviderCoFH;
import cofh.core.registries.DeferredRegisterCoFH;
import cofh.core.util.references.CoFHTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static cofh.core.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.init.TCoreIDs.*;

public class TCoreRecipes extends RecipeProviderCoFH {

    public TCoreRecipes(DataGenerator generatorIn) {

        super(generatorIn, ID_THERMAL);
    }

    @Override
    public String getName() {

        return "Thermal Core: Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        generateStorageRecipes(reg, consumer, reg.get(ID_CHARCOAL_BLOCK), Items.CHARCOAL);
        generateStorageRecipes(reg, consumer, reg.get(ID_BAMBOO_BLOCK), Items.BAMBOO);
        generateStorageRecipes(reg, consumer, reg.get(ID_SUGAR_CANE_BLOCK), Items.SUGAR_CANE);
        generateStorageRecipes(reg, consumer, reg.get(ID_GUNPOWDER_BLOCK), Items.GUNPOWDER);

        generateStorageRecipes(reg, consumer, reg.get(ID_APPLE_BLOCK), Items.APPLE);
        generateStorageRecipes(reg, consumer, reg.get(ID_BEETROOT_BLOCK), Items.BEETROOT);
        generateStorageRecipes(reg, consumer, reg.get(ID_CARROT_BLOCK), Items.CARROT);
        generateStorageRecipes(reg, consumer, reg.get(ID_POTATO_BLOCK), Items.POTATO);

        generateStorageRecipes(reg, consumer, reg.get(ID_APATITE_BLOCK), reg.get("apatite"));
        generateStorageRecipes(reg, consumer, reg.get(ID_CINNABAR_BLOCK), reg.get("cinnabar"));
        generateStorageRecipes(reg, consumer, reg.get(ID_NITER_BLOCK), reg.get("niter"));
        generateStorageRecipes(reg, consumer, reg.get(ID_SULFUR_BLOCK), reg.get("sulfur"));

        generateStorageRecipes(reg, consumer, "copper");
        generateStorageRecipes(reg, consumer, "tin");
        generateStorageRecipes(reg, consumer, "lead");
        generateStorageRecipes(reg, consumer, "silver");
        generateStorageRecipes(reg, consumer, "nickel");

        generateStorageRecipes(reg, consumer, "bronze");
        generateStorageRecipes(reg, consumer, "electrum");
        generateStorageRecipes(reg, consumer, "invar");
        generateStorageRecipes(reg, consumer, "constantan");

        generateSmeltingAndBlastingRecipes(reg, consumer, "copper", 0.6F);
        generateSmeltingAndBlastingRecipes(reg, consumer, "tin", 0.6F);
        generateSmeltingAndBlastingRecipes(reg, consumer, "lead", 0.8F);
        generateSmeltingAndBlastingRecipes(reg, consumer, "silver", 1.0F);
        generateSmeltingAndBlastingRecipes(reg, consumer, "nickel", 1.0F);

        generateSmeltingAndBlastingRecipes(reg, consumer, "bronze", 0);
        generateSmeltingAndBlastingRecipes(reg, consumer, "electrum", 0);
        generateSmeltingAndBlastingRecipes(reg, consumer, "invar", 0);
        generateSmeltingAndBlastingRecipes(reg, consumer, "constantan", 0);

        generateGearRecipe(consumer, reg.get("iron_gear"), Items.IRON_INGOT, forgeTag("ingots/iron"));
        generateGearRecipe(consumer, reg.get("gold_gear"), Items.GOLD_INGOT, forgeTag("ingots/gold"));

        generateGearRecipe(consumer, reg.get("diamond_gear"), Items.IRON_INGOT, forgeTag("gems/diamond"));
        generateGearRecipe(consumer, reg.get("emerald_gear"), Items.IRON_INGOT, forgeTag("gems/emerald"));
        generateGearRecipe(consumer, reg.get("quartz_gear"), Items.IRON_INGOT, forgeTag("gems/quartz"));
        generateGearRecipe(consumer, reg.get("lapis_gear"), Items.IRON_INGOT, forgeTag("gems/lapis"));

        generateStorageRecipes(reg, consumer, reg.get(ID_COAL_COKE_BLOCK), reg.get("coal_coke"));
        generateStorageRecipes(reg, consumer, reg.get(ID_SAWDUST_BLOCK), reg.get("sawdust"));
        generateStorageRecipes(reg, consumer, reg.get(ID_ROSIN_BLOCK), reg.get("rosin"));
        generateStorageRecipes(reg, consumer, reg.get(ID_RUBBER_BLOCK), reg.get("rubber"));
        generateStorageRecipes(reg, consumer, reg.get(ID_CURED_RUBBER_BLOCK), reg.get("cured_rubber"));
        generateStorageRecipes(reg, consumer, reg.get(ID_SLAG_BLOCK), reg.get("slag"));
        generateStorageRecipes(reg, consumer, reg.get(ID_RICH_SLAG_BLOCK), reg.get("rich_slag"));

        generateStorageRecipes(reg, consumer, "signalum");
        generateStorageRecipes(reg, consumer, "lumium");
        generateStorageRecipes(reg, consumer, "enderium");

        generateSmeltingAndBlastingRecipes(reg, consumer, "signalum", 0);
        generateSmeltingAndBlastingRecipes(reg, consumer, "lumium", 0);
        generateSmeltingAndBlastingRecipes(reg, consumer, "enderium", 0);

        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get("iron_dust"), Items.IRON_INGOT, 0.0F, "smelting", "_dust");
        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get("gold_dust"), Items.GOLD_INGOT, 0.0F, "smelting", "_dust");

        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get(ID_APATITE_ORE), reg.get("apatite"), 0.5F, "smelting");
        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get(ID_CINNABAR_ORE), reg.get("cinnabar"), 0.5F, "smelting");
        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get(ID_NITER_ORE), reg.get("niter"), 0.5F, "smelting");
        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get(ID_SULFUR_ORE), reg.get("sulfur"), 0.5F, "smelting");

        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get("rubber"), reg.get("cured_rubber"), 0.2F, "smelting");

        generateAlloyRecipes(consumer);
        generateArmorRecipes(consumer);
        generateAugmentRecipes(consumer);
        generateBasicRecipes(consumer);
        generateChargeRecipes(consumer);
        generateComponentRecipes(consumer);
        generateDeviceRecipes(consumer);
        generateExplosiveRecipes(consumer);
        generatePhytogroRecipes(consumer);
    }

    // region HELPERS
    private void generateAlloyRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("bronze_dust"), 4)
                .addIngredient(CoFHTags.Items.DUSTS_COPPER)
                .addIngredient(CoFHTags.Items.DUSTS_COPPER)
                .addIngredient(CoFHTags.Items.DUSTS_COPPER)
                .addIngredient(CoFHTags.Items.DUSTS_TIN)
                .addCriterion("has_copper_dust", hasItem(CoFHTags.Items.DUSTS_COPPER))
                .addCriterion("has_tin_dust", hasItem(CoFHTags.Items.DUSTS_TIN))
                .build(consumer, ID_THERMAL + ":bronze_dust_4");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("electrum_dust"), 2)
                .addIngredient(CoFHTags.Items.DUSTS_GOLD)
                .addIngredient(CoFHTags.Items.DUSTS_SILVER)
                .addCriterion("has_gold_dust", hasItem(CoFHTags.Items.DUSTS_GOLD))
                .addCriterion("has_silver_dust", hasItem(CoFHTags.Items.DUSTS_SILVER))
                .build(consumer, ID_THERMAL + ":electrum_dust_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("invar_dust"), 3)
                .addIngredient(CoFHTags.Items.DUSTS_IRON)
                .addIngredient(CoFHTags.Items.DUSTS_IRON)
                .addIngredient(CoFHTags.Items.DUSTS_NICKEL)
                .addCriterion("has_iron_dust", hasItem(CoFHTags.Items.DUSTS_IRON))
                .addCriterion("has_nickel_dust", hasItem(CoFHTags.Items.DUSTS_NICKEL))
                .build(consumer, ID_THERMAL + ":invar_dust_3");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("constantan_dust"), 2)
                .addIngredient(CoFHTags.Items.DUSTS_COPPER)
                .addIngredient(CoFHTags.Items.DUSTS_NICKEL)
                .addCriterion("has_copper_dust", hasItem(CoFHTags.Items.DUSTS_COPPER))
                .addCriterion("has_nickel_dust", hasItem(CoFHTags.Items.DUSTS_NICKEL))
                .build(consumer, ID_THERMAL + ":constantan_dust_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("signalum_dust"), 4)
                .addIngredient(CoFHTags.Items.DUSTS_COPPER)
                .addIngredient(CoFHTags.Items.DUSTS_COPPER)
                .addIngredient(CoFHTags.Items.DUSTS_COPPER)
                .addIngredient(CoFHTags.Items.DUSTS_SILVER)
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addCriterion("has_redstone_dust", hasItem(Tags.Items.DUSTS_REDSTONE))
                .build(consumer, ID_THERMAL + ":signalum_dust_4");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("lumium_dust"), 4)
                .addIngredient(CoFHTags.Items.DUSTS_TIN)
                .addIngredient(CoFHTags.Items.DUSTS_TIN)
                .addIngredient(CoFHTags.Items.DUSTS_TIN)
                .addIngredient(CoFHTags.Items.DUSTS_SILVER)
                .addIngredient(Tags.Items.DUSTS_GLOWSTONE)
                .addIngredient(Tags.Items.DUSTS_GLOWSTONE)
                .addCriterion("has_glowstone_dust", hasItem(Tags.Items.DUSTS_GLOWSTONE))
                .build(consumer, ID_THERMAL + ":lumium_dust_4");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("enderium_dust"), 2)
                .addIngredient(CoFHTags.Items.DUSTS_LEAD)
                .addIngredient(CoFHTags.Items.DUSTS_LEAD)
                .addIngredient(CoFHTags.Items.DUSTS_LEAD)
                .addIngredient(CoFHTags.Items.DUSTS_DIAMOND)
                .addIngredient(fromTags(Tags.Items.ENDER_PEARLS, CoFHTags.Items.DUSTS_ENDER_PEARL))
                .addIngredient(fromTags(Tags.Items.ENDER_PEARLS, CoFHTags.Items.DUSTS_ENDER_PEARL))
                .addCriterion("has_ender_pearl", hasItem(Tags.Items.ENDER_PEARLS))
                .build(consumer, ID_THERMAL + ":enderium_dust_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("bronze_ingot"), 4)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_COPPER, CoFHTags.Items.INGOTS_COPPER))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_COPPER, CoFHTags.Items.INGOTS_COPPER))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_COPPER, CoFHTags.Items.INGOTS_COPPER))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_TIN, CoFHTags.Items.INGOTS_TIN))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_copper_dust", hasItem(CoFHTags.Items.DUSTS_COPPER))
                .addCriterion("has_copper_ingot", hasItem(CoFHTags.Items.INGOTS_COPPER))
                .addCriterion("has_tin_dust", hasItem(CoFHTags.Items.DUSTS_TIN))
                .addCriterion("has_tin_ingot", hasItem(CoFHTags.Items.INGOTS_TIN))
                .build(consumer, ID_THERMAL + ":fire_charge/bronze_ingot_4");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("electrum_ingot"), 2)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_GOLD, Tags.Items.INGOTS_GOLD))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_SILVER, CoFHTags.Items.INGOTS_SILVER))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_gold_dust", hasItem(CoFHTags.Items.DUSTS_GOLD))
                .addCriterion("has_gold_ingot", hasItem(Tags.Items.INGOTS_GOLD))
                .addCriterion("has_silver_dust", hasItem(CoFHTags.Items.DUSTS_SILVER))
                .addCriterion("has_silver_ingot", hasItem(CoFHTags.Items.INGOTS_SILVER))
                .build(consumer, ID_THERMAL + ":fire_charge/electrum_ingot_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("invar_ingot"), 3)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_IRON, Tags.Items.INGOTS_IRON))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_IRON, Tags.Items.INGOTS_IRON))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_NICKEL, CoFHTags.Items.INGOTS_NICKEL))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_iron_dust", hasItem(CoFHTags.Items.DUSTS_IRON))
                .addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON))
                .addCriterion("has_nickel_dust", hasItem(CoFHTags.Items.DUSTS_NICKEL))
                .addCriterion("has_nickel_ingot", hasItem(CoFHTags.Items.INGOTS_NICKEL))
                .build(consumer, ID_THERMAL + ":fire_charge/invar_ingot_3");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("constantan_ingot"), 2)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_COPPER, CoFHTags.Items.INGOTS_COPPER))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_NICKEL, CoFHTags.Items.INGOTS_NICKEL))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_copper_dust", hasItem(CoFHTags.Items.DUSTS_COPPER))
                .addCriterion("has_copper_ingot", hasItem(CoFHTags.Items.INGOTS_COPPER))
                .addCriterion("has_nickel_dust", hasItem(CoFHTags.Items.DUSTS_NICKEL))
                .addCriterion("has_nickel_ingot", hasItem(CoFHTags.Items.INGOTS_NICKEL))
                .build(consumer, ID_THERMAL + ":fire_charge/constantan_ingot_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("signalum_ingot"), 4)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_COPPER, CoFHTags.Items.INGOTS_COPPER))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_COPPER, CoFHTags.Items.INGOTS_COPPER))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_COPPER, CoFHTags.Items.INGOTS_COPPER))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_SILVER, CoFHTags.Items.INGOTS_SILVER))
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_redstone_dust", hasItem(Tags.Items.DUSTS_REDSTONE))
                .build(consumer, ID_THERMAL + ":fire_charge/signalum_ingot_4");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("lumium_ingot"), 4)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_TIN, CoFHTags.Items.INGOTS_TIN))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_TIN, CoFHTags.Items.INGOTS_TIN))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_TIN, CoFHTags.Items.INGOTS_TIN))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_SILVER, CoFHTags.Items.INGOTS_SILVER))
                .addIngredient(Tags.Items.DUSTS_GLOWSTONE)
                .addIngredient(Tags.Items.DUSTS_GLOWSTONE)
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_glowstone_dust", hasItem(Tags.Items.DUSTS_GLOWSTONE))
                .build(consumer, ID_THERMAL + ":fire_charge/lumium_ingot_4");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("enderium_ingot"), 2)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_LEAD, CoFHTags.Items.INGOTS_LEAD))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_LEAD, CoFHTags.Items.INGOTS_LEAD))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_LEAD, CoFHTags.Items.INGOTS_LEAD))
                .addIngredient(CoFHTags.Items.DUSTS_DIAMOND)
                .addIngredient(fromTags(Tags.Items.ENDER_PEARLS, CoFHTags.Items.DUSTS_ENDER_PEARL))
                .addIngredient(fromTags(Tags.Items.ENDER_PEARLS, CoFHTags.Items.DUSTS_ENDER_PEARL))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_ender_pearl", hasItem(Tags.Items.ENDER_PEARLS))
                .build(consumer, ID_THERMAL + ":fire_charge/enderium_ingot_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("obsidian_glass"), 2)
                .addIngredient(Tags.Items.OBSIDIAN)
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_QUARTZ, Tags.Items.GEMS_QUARTZ))
                .addIngredient(Tags.Items.SAND)
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_obsidian", hasItem(Tags.Items.OBSIDIAN))
                .build(consumer, ID_THERMAL + ":fire_charge/obsidian_glass_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("signalum_glass"), 2)
                .addIngredient(reg.get("obsidian_glass"))
                .addIngredient(reg.get("obsidian_glass"))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_SIGNALUM, CoFHTags.Items.INGOTS_SIGNALUM))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_signalum_dust", hasItem(CoFHTags.Items.DUSTS_SIGNALUM))
                .addCriterion("has_signalum_ingot", hasItem(CoFHTags.Items.INGOTS_SIGNALUM))
                .build(consumer, ID_THERMAL + ":fire_charge/signalum_glass_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("lumium_glass"), 2)
                .addIngredient(reg.get("obsidian_glass"))
                .addIngredient(reg.get("obsidian_glass"))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_LUMIUM, CoFHTags.Items.INGOTS_LUMIUM))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_lumium_dust", hasItem(CoFHTags.Items.DUSTS_LUMIUM))
                .addCriterion("has_lumium_ingot", hasItem(CoFHTags.Items.INGOTS_LUMIUM))
                .build(consumer, ID_THERMAL + ":fire_charge/lumium_glass_2");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("enderium_glass"), 2)
                .addIngredient(reg.get("obsidian_glass"))
                .addIngredient(reg.get("obsidian_glass"))
                .addIngredient(fromTags(CoFHTags.Items.DUSTS_ENDERIUM, CoFHTags.Items.INGOTS_ENDERIUM))
                .addIngredient(Items.FIRE_CHARGE)
                .addCriterion("has_enderium_dust", hasItem(CoFHTags.Items.DUSTS_ENDERIUM))
                .addCriterion("has_enderium_ingot", hasItem(CoFHTags.Items.INGOTS_ENDERIUM))
                .build(consumer, ID_THERMAL + ":fire_charge/enderium_glass_2");
    }

    private void generateArmorRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;
        String folder = "armor";
        Item result;

        Item beekeeperFabric = reg.get("beekeeper_fabric");
        Item divingFabric = reg.get("diving_fabric");
        Item hazmatFabric = reg.get("hazmat_fabric");

        result = reg.get(ID_BEEKEEPER_HELMET);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('X', beekeeperFabric)
                .patternLine("XXX")
                .patternLine("X X")
                .addCriterion("has_fabric", hasItem(beekeeperFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_BEEKEEPER_CHESTPLATE);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('X', beekeeperFabric)
                .patternLine("X X")
                .patternLine("XXX")
                .patternLine("XXX")
                .addCriterion("has_fabric", hasItem(beekeeperFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_BEEKEEPER_LEGGINGS);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('X', beekeeperFabric)
                .patternLine("XXX")
                .patternLine("X X")
                .patternLine("X X")
                .addCriterion("has_fabric", hasItem(beekeeperFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_BEEKEEPER_BOOTS);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('L', Tags.Items.LEATHER)
                .key('X', beekeeperFabric)
                .patternLine("X X")
                .patternLine("L L")
                .addCriterion("has_fabric", hasItem(beekeeperFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_DIVING_HELMET);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', Tags.Items.GLASS_PANES)
                .key('I', Tags.Items.INGOTS_GOLD)
                .key('X', divingFabric)
                .patternLine("XIX")
                .patternLine("IGI")
                .addCriterion("has_fabric", hasItem(divingFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_DIVING_CHESTPLATE);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('I', Tags.Items.INGOTS_GOLD)
                .key('X', divingFabric)
                .patternLine("X X")
                .patternLine("IXI")
                .patternLine("XXX")
                .addCriterion("has_fabric", hasItem(divingFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_DIVING_LEGGINGS);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('I', Tags.Items.INGOTS_GOLD)
                .key('X', divingFabric)
                .patternLine("XXX")
                .patternLine("I I")
                .patternLine("X X")
                .addCriterion("has_fabric", hasItem(divingFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_DIVING_BOOTS);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('L', Tags.Items.LEATHER)
                .key('I', Tags.Items.INGOTS_GOLD)
                .key('X', divingFabric)
                .patternLine("X X")
                .patternLine("LIL")
                .addCriterion("has_fabric", hasItem(divingFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_HAZMAT_HELMET);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', Tags.Items.GLASS_PANES)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('X', hazmatFabric)
                .patternLine("XIX")
                .patternLine("IGI")
                .addCriterion("has_fabric", hasItem(hazmatFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_HAZMAT_CHESTPLATE);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('X', hazmatFabric)
                .patternLine("X X")
                .patternLine("IXI")
                .patternLine("XXX")
                .addCriterion("has_fabric", hasItem(hazmatFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_HAZMAT_LEGGINGS);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('X', hazmatFabric)
                .patternLine("XXX")
                .patternLine("I I")
                .patternLine("X X")
                .addCriterion("has_fabric", hasItem(hazmatFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get(ID_HAZMAT_BOOTS);
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('L', Tags.Items.LEATHER)
                .key('R', reg.get("cured_rubber"))
                .key('X', hazmatFabric)
                .patternLine("X X")
                .patternLine("LRL")
                .addCriterion("has_fabric", hasItem(hazmatFabric))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());
    }

    private void generateAugmentRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;
        String folder = "augments";
        Item result;

        Item redstoneServo = reg.get("redstone_servo");
        Item rfCoil = reg.get("rf_coil");

        result = reg.get("area_radius_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', CoFHTags.Items.GEARS_IRON)
                .key('I', CoFHTags.Items.INGOTS_TIN)
                .key('X', redstoneServo)
                .patternLine(" G ")
                .patternLine("IXI")
                .patternLine(" G ")
                .addCriterion("has_redstone_servo", hasItem(redstoneServo))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("dynamo_output_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', CoFHTags.Items.GEARS_SILVER)
                .key('S', CoFHTags.Items.PLATES_SIGNALUM)
                .key('X', CoFHTags.Items.HARDENED_GLASS)
                .patternLine(" G ")
                .patternLine("SXS")
                .patternLine(" G ")
                .addCriterion("has_hardened_glass", hasItem(CoFHTags.Items.HARDENED_GLASS))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("dynamo_fuel_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', CoFHTags.Items.GEARS_LEAD)
                .key('L', CoFHTags.Items.PLATES_LUMIUM)
                .key('X', CoFHTags.Items.HARDENED_GLASS)
                .patternLine(" G ")
                .patternLine("LXL")
                .patternLine(" G ")
                .addCriterion("has_hardened_glass", hasItem(CoFHTags.Items.HARDENED_GLASS))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("machine_speed_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('E', CoFHTags.Items.PLATES_ELECTRUM)
                .key('L', CoFHTags.Items.GEARS_LEAD)
                .key('X', rfCoil)
                .patternLine(" L ")
                .patternLine("EXE")
                .patternLine(" L ")
                .addCriterion("has_rf_coil", hasItem(rfCoil))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("machine_output_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('B', CoFHTags.Items.GEARS_BRONZE)
                .key('I', CoFHTags.Items.PLATES_INVAR)
                .key('X', redstoneServo)
                .patternLine(" B ")
                .patternLine("IXI")
                .patternLine(" B ")
                .addCriterion("has_redstone_servo", hasItem(redstoneServo))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("machine_catalyst_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('C', CoFHTags.Items.GEARS_CONSTANTAN)
                .key('L', CoFHTags.Items.PLATES_LEAD)
                .key('X', redstoneServo)
                .patternLine(" C ")
                .patternLine("LXL")
                .patternLine(" C ")
                .addCriterion("has_redstone_servo", hasItem(redstoneServo))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("machine_cycle_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('C', CoFHTags.Items.PLATES_CONSTANTAN)
                .key('G', CoFHTags.Items.GEARS_SIGNALUM)
                .key('S', CoFHTags.Items.PLATES_SILVER)
                .key('X', redstoneServo)
                .patternLine("SGS")
                .patternLine("CXC")
                .patternLine("SGS")
                .addCriterion("has_redstone_servo", hasItem(redstoneServo))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("potion_amplifier_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', CoFHTags.Items.GEARS_SIGNALUM)
                .key('I', CoFHTags.Items.INGOTS_COPPER)
                .key('X', CoFHTags.Items.HARDENED_GLASS)
                .patternLine(" G ")
                .patternLine("IXI")
                .patternLine(" G ")
                .addCriterion("has_hardened_glass", hasItem(CoFHTags.Items.HARDENED_GLASS))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("potion_duration_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', CoFHTags.Items.GEARS_LUMIUM)
                .key('I', CoFHTags.Items.INGOTS_COPPER)
                .key('X', CoFHTags.Items.HARDENED_GLASS)
                .patternLine(" G ")
                .patternLine("IXI")
                .patternLine(" G ")
                .addCriterion("has_hardened_glass", hasItem(CoFHTags.Items.HARDENED_GLASS))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("rf_coil_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', Tags.Items.INGOTS_GOLD)
                .key('S', CoFHTags.Items.INGOTS_SILVER)
                .key('X', rfCoil)
                .patternLine(" G ")
                .patternLine("SXS")
                .patternLine(" G ")
                .addCriterion("has_rf_coil", hasItem(rfCoil))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("rf_coil_storage_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', Tags.Items.INGOTS_GOLD)
                .key('S', CoFHTags.Items.INGOTS_SILVER)
                .key('X', rfCoil)
                .patternLine(" S ")
                .patternLine("GXG")
                .patternLine(" G ")
                .addCriterion("has_rf_coil", hasItem(rfCoil))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("rf_coil_xfer_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', Tags.Items.INGOTS_GOLD)
                .key('S', CoFHTags.Items.INGOTS_SILVER)
                .key('X', rfCoil)
                .patternLine(" S ")
                .patternLine("SXS")
                .patternLine(" G ")
                .addCriterion("has_rf_coil", hasItem(rfCoil))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("fluid_tank_augment");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('R', ITEMS.get("cured_rubber"))
                .key('X', CoFHTags.Items.HARDENED_GLASS)
                .patternLine("RIR")
                .patternLine("IXI")
                .patternLine("RIR")
                .addCriterion("has_hardened_glass", hasItem(CoFHTags.Items.HARDENED_GLASS))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("upgrade_augment_1");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', Tags.Items.GLASS)
                .key('I', CoFHTags.Items.INGOTS_INVAR)
                .key('R', Tags.Items.DUSTS_REDSTONE)
                .key('X', CoFHTags.Items.GEARS_GOLD)
                .patternLine("IGI")
                .patternLine("RXR")
                .patternLine("IGI")
                .addCriterion("has_invar_ingot", hasItem(CoFHTags.Items.INGOTS_INVAR))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("upgrade_augment_2");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', Tags.Items.GEMS_QUARTZ)
                .key('I', CoFHTags.Items.INGOTS_ELECTRUM)
                .key('R', CoFHTags.Items.GEARS_SIGNALUM)
                .key('X', reg.get("upgrade_augment_1"))
                .patternLine("IGI")
                .patternLine("RXR")
                .patternLine("IGI")
                .addCriterion("has_electrum_ingot", hasItem(CoFHTags.Items.INGOTS_ELECTRUM))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("upgrade_augment_3");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', CoFHTags.Items.HARDENED_GLASS)
                .key('I', CoFHTags.Items.INGOTS_ENDERIUM)
                .key('R', CoFHTags.Items.GEARS_LUMIUM)
                .key('X', reg.get("upgrade_augment_2"))
                .patternLine("IGI")
                .patternLine("RXR")
                .patternLine("IGI")
                .addCriterion("has_enderium_ingot", hasItem(CoFHTags.Items.INGOTS_ENDERIUM))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());
    }

    private void generateBasicRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;
        String folder = "tools";
        Item result;

        result = reg.get("wrench");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('G', CoFHTags.Items.GEARS_IRON)
                .patternLine("I I")
                .patternLine(" G ")
                .patternLine(" I ")
                .addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());
        //                .key('I', Tags.Items.INGOTS_IRON)
        //                .key('T', CoFHTags.Items.INGOTS_TIN)
        //                .patternLine("I I")
        //                .patternLine(" T ")
        //                .patternLine(" I ")
        //                .addCriterion("has_tin", hasItem(CoFHTags.Items.INGOTS_TIN))
        //                .build(consumer);

        result = reg.get("redprint");
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(Items.PAPER)
                .addIngredient(Items.PAPER)
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addIngredient(Tags.Items.DUSTS_REDSTONE)
                .addCriterion("has_redstone", hasItem(Tags.Items.DUSTS_REDSTONE))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("lock");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('i', Tags.Items.NUGGETS_IRON)
                .key('S', CoFHTags.Items.INGOTS_SIGNALUM)
                .patternLine(" i ")
                .patternLine("iSi")
                .patternLine("iii")
                .addCriterion("has_signalum_ingot", hasItem(CoFHTags.Items.INGOTS_SIGNALUM))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        result = reg.get("detonator");
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('G', CoFHTags.Items.GEARS_SIGNALUM)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('S', CoFHTags.Items.INGOTS_SILVER)
                .patternLine(" S ")
                .patternLine("IGI")
                .patternLine("III")
                .addCriterion("has_signalum_ingot", hasItem(CoFHTags.Items.INGOTS_SIGNALUM))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        //        ShapedRecipeBuilder.shapedRecipe(reg.get("rf_potato"))
        //                .key('D', Tags.Items.DUSTS_REDSTONE)
        //                .key('L', CoFHTags.Items.NUGGETS_LEAD)
        //                .key('P', Tags.Items.CROPS_POTATO)
        //                .key('R', reg.get("cured_rubber"))
        //                .patternLine("LDL")
        //                .patternLine("RPR")
        //                .patternLine("DLD")
        //                .addCriterion("has_potato", hasItem(Tags.Items.CROPS_POTATO))
        //                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath());

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("basalz_powder"), 2)
                .addIngredient(reg.get("basalz_rod"))
                .addCriterion("has_basalz_rod", hasItem(reg.get("basalz_rod")))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("blitz_powder"), 2)
                .addIngredient(reg.get("blitz_rod"))
                .addCriterion("has_blitz_rod", hasItem(reg.get("blitz_rod")))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("blizz_powder"), 2)
                .addIngredient(reg.get("blizz_rod"))
                .addCriterion("has_blizz_rod", hasItem(reg.get("blizz_rod")))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.CYAN_DYE)
                .addIngredient(reg.get("apatite"))
                .addCriterion("has_apatite", hasItem(reg.get("apatite")))
                .build(consumer, ID_THERMAL + ":cyan_dye_from_apatite");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("rubber"), 3)
                .addIngredient(reg.get("latex_bucket"))
                .addCriterion("latex_bucket", hasItem(reg.get("latex_bucket")))
                .build(consumer, ID_THERMAL + ":rubber_3");

        ShapedRecipeBuilder.shapedRecipe(reg.get("rubber"), 1)
                .key('B', Items.WATER_BUCKET)
                .key('#', Items.DANDELION)
                .patternLine("###")
                .patternLine("#B#")
                .patternLine("###")
                .addCriterion("has_dandelion", hasItem(Items.DANDELION))
                .build(consumer, ID_THERMAL + ":rubber_from_dandelion");

        ShapedRecipeBuilder.shapedRecipe(reg.get("rubber"), 1)
                .key('B', Items.WATER_BUCKET)
                .key('#', Items.VINE)
                .patternLine("###")
                .patternLine("#B#")
                .patternLine("###")
                .addCriterion("has_vine", hasItem(Items.VINE))
                .build(consumer, ID_THERMAL + ":rubber_from_vine");

        // ROCKWOOL
        Item rockwool = reg.get(ID_WHITE_ROCKWOOL);
        folder = "rockwool";

        generateSmeltingAndBlastingRecipes(reg, consumer, reg.get("slag"), rockwool, 0.1F, "rockwool");

        //        ShapelessRecipeBuilder.shapelessRecipe(reg.get(ID_WHITE_ROCKWOOL))
        //                .addIngredient(rockwool)
        //                .addIngredient(Tags.Items.DYES_WHITE)
        //                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
        //                .build(consumer);

        result = reg.get(ID_ORANGE_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_ORANGE)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_MAGENTA_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_MAGENTA)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_LIGHT_BLUE_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_LIGHT_BLUE)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_YELLOW_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_YELLOW)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_LIME_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_LIME)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_PINK_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_PINK)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_GRAY_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_GRAY)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_LIGHT_GRAY_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_LIGHT_GRAY)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_CYAN_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_CYAN)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_PURPLE_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_PURPLE)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_BLUE_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_BLUE)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_BROWN_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_BROWN)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_GREEN_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_GREEN)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_RED_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_RED)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");

        result = reg.get(ID_BLACK_ROCKWOOL);
        ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(rockwool)
                .addIngredient(Tags.Items.DYES_BLACK)
                .addCriterion("has_" + rockwool.getRegistryName().getPath(), hasItem(rockwool))
                .build(consumer, this.modid + ":" + folder + "/" + result.getRegistryName().getPath() + "_from_dye");
    }

    private void generateComponentRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        ShapedRecipeBuilder.shapedRecipe(reg.get("machine_frame"))
                .key('G', Tags.Items.GLASS)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('T', CoFHTags.Items.GEARS_TIN)
                .patternLine("IGI")
                .patternLine("GTG")
                .patternLine("IGI")
                .addCriterion("has_tin", hasItem(CoFHTags.Items.INGOTS_TIN))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("redstone_servo"))
                .key('I', Tags.Items.INGOTS_IRON)
                .key('R', Tags.Items.DUSTS_REDSTONE)
                .patternLine(" R ")
                .patternLine(" I ")
                .patternLine(" R ")
                .addCriterion("has_redstone_dust", hasItem(Tags.Items.DUSTS_REDSTONE))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("rf_coil"))
                .key('I', Tags.Items.INGOTS_GOLD)
                .key('R', Tags.Items.DUSTS_REDSTONE)
                .patternLine("  R")
                .patternLine(" I ")
                .patternLine("R  ")
                .addCriterion("has_redstone_dust", hasItem(Tags.Items.DUSTS_REDSTONE))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("drill_head"))
                .key('C', CoFHTags.Items.INGOTS_COPPER)
                .key('I', Tags.Items.INGOTS_IRON)
                .patternLine(" I ")
                .patternLine("ICI")
                .patternLine("III")
                .addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("saw_blade"))
                .key('C', CoFHTags.Items.INGOTS_COPPER)
                .key('I', Tags.Items.INGOTS_IRON)
                .patternLine("II ")
                .patternLine("ICI")
                .patternLine(" II")
                .addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("beekeeper_fabric"))
                .key('S', Tags.Items.STRING)
                .key('H', Items.HONEYCOMB)
                .patternLine(" S ")
                .patternLine("SHS")
                .patternLine(" S ")
                .addCriterion("has_honeycomb", hasItem(Items.HONEYCOMB))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("diving_fabric"))
                .key('S', Tags.Items.STRING)
                .key('H', Tags.Items.GEMS_PRISMARINE)
                .patternLine(" S ")
                .patternLine("SHS")
                .patternLine(" S ")
                .addCriterion("has_prismarine", hasItem(Tags.Items.GEMS_PRISMARINE))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("hazmat_fabric"))
                .key('S', Tags.Items.STRING)
                .key('H', reg.get("cured_rubber"))
                .patternLine(" S ")
                .patternLine("SHS")
                .patternLine(" S ")
                .addCriterion("has_cured_rubber", hasItem(reg.get("cured_rubber")))
                .build(consumer);
    }

    private void generateDeviceRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        Item redstoneServo = reg.get("redstone_servo");
        Item rfCoil = reg.get("rf_coil");

        ShapedRecipeBuilder.shapedRecipe(reg.get(ID_DEVICE_HIVE_EXTRACTOR))
                .key('C', Items.SHEARS)
                .key('G', Tags.Items.GLASS)
                .key('P', redstoneServo)
                .key('X', CoFHTags.Items.GEARS_IRON)
                .key('W', ItemTags.PLANKS)
                .patternLine("WXW")
                .patternLine("GCG")
                .patternLine("WPW")
                .addCriterion("has_redstone_servo", hasItem(redstoneServo))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get(ID_DEVICE_TREE_EXTRACTOR))
                .key('C', Items.BUCKET)
                .key('G', Tags.Items.GLASS)
                .key('P', redstoneServo)
                .key('X', CoFHTags.Items.GEARS_IRON)
                .key('W', ItemTags.PLANKS)
                .patternLine("WXW")
                .patternLine("GCG")
                .patternLine("WPW")
                .addCriterion("has_redstone_servo", hasItem(redstoneServo))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get(ID_DEVICE_WATER_GEN))
                .key('C', CoFHTags.Items.INGOTS_COPPER)
                .key('G', Tags.Items.GLASS)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', redstoneServo)
                .key('X', Items.BUCKET)
                .patternLine("CIC")
                .patternLine("GXG")
                .patternLine("CPC")
                .addCriterion("has_redstone_servo", hasItem(redstoneServo))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get(ID_TINKER_BENCH))
                .key('C', Blocks.CRAFTING_TABLE)
                .key('G', Tags.Items.GLASS)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', rfCoil)
                .key('W', ItemTags.PLANKS)
                .patternLine("III")
                .patternLine("GCG")
                .patternLine("WPW")
                .addCriterion("has_rf_coil", hasItem(rfCoil))
                .build(consumer);
    }

    private void generateExplosiveRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        ShapelessRecipeBuilder.shapelessRecipe(Items.GUNPOWDER, 4)
                .addIngredient(Items.CHARCOAL)
                .addIngredient(fromTags(CoFHTags.Items.GEMS_NITER, CoFHTags.Items.DUSTS_NITER))
                .addIngredient(fromTags(CoFHTags.Items.GEMS_NITER, CoFHTags.Items.DUSTS_NITER))
                .addIngredient(fromTags(CoFHTags.Items.GEMS_SULFUR, CoFHTags.Items.DUSTS_SULFUR))
                .addCriterion("has_gunpowder", hasItem(Tags.Items.GUNPOWDER))
                .build(consumer, ID_THERMAL + ":gunpowder_4");

        ShapedRecipeBuilder.shapedRecipe(reg.get("explosive_grenade"), 4)
                .key('G', Tags.Items.GUNPOWDER)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', Tags.Items.SAND)
                .patternLine("GPG")
                .patternLine("PIP")
                .patternLine("GPG")
                .addCriterion("has_gunpowder", hasItem(Tags.Items.GUNPOWDER))
                .build(consumer, ID_THERMAL + ":explosive_grenade_4");

        ShapedRecipeBuilder.shapedRecipe(reg.get("fire_grenade"), 4)
                .key('G', Tags.Items.GUNPOWDER)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', Items.BLAZE_POWDER)
                .patternLine("GPG")
                .patternLine("PIP")
                .patternLine("GPG")
                .addCriterion("has_blaze_powder", hasItem(Items.BLAZE_POWDER))
                .build(consumer, ID_THERMAL + ":fire_grenade_4");

        ShapedRecipeBuilder.shapedRecipe(reg.get("earth_grenade"), 4)
                .key('G', Tags.Items.GUNPOWDER)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', reg.get("basalz_powder"))
                .patternLine("GPG")
                .patternLine("PIP")
                .patternLine("GPG")
                .addCriterion("has_basalz_powder", hasItem(reg.get("basalz_powder")))
                .build(consumer, ID_THERMAL + ":earth_grenade_4");

        ShapedRecipeBuilder.shapedRecipe(reg.get("ice_grenade"), 4)
                .key('G', Tags.Items.GUNPOWDER)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', reg.get("blizz_powder"))
                .patternLine("GPG")
                .patternLine("PIP")
                .patternLine("GPG")
                .addCriterion("has_blizz_powder", hasItem(reg.get("blizz_powder")))
                .build(consumer, ID_THERMAL + ":ice_grenade_4");

        ShapedRecipeBuilder.shapedRecipe(reg.get("lightning_grenade"), 4)
                .key('G', Tags.Items.GUNPOWDER)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', reg.get("blitz_powder"))
                .patternLine("GPG")
                .patternLine("PIP")
                .patternLine("GPG")
                .addCriterion("has_blitz_powder", hasItem(reg.get("blitz_powder")))
                .build(consumer, ID_THERMAL + ":lightning_grenade_4");

        ShapedRecipeBuilder.shapedRecipe(reg.get("fire_tnt"))
                .key('G', Tags.Items.GUNPOWDER)
                .key('P', Items.BLAZE_POWDER)
                .patternLine("GPG")
                .patternLine("PGP")
                .patternLine("GPG")
                .addCriterion("has_blaze_powder", hasItem(Items.BLAZE_POWDER))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("earth_tnt"))
                .key('G', Tags.Items.GUNPOWDER)
                .key('P', reg.get("basalz_powder"))
                .patternLine("GPG")
                .patternLine("PGP")
                .patternLine("GPG")
                .addCriterion("has_basalz_powder", hasItem(reg.get("basalz_powder")))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("ice_tnt"))
                .key('G', Tags.Items.GUNPOWDER)
                .key('P', reg.get("blizz_powder"))
                .patternLine("GPG")
                .patternLine("PGP")
                .patternLine("GPG")
                .addCriterion("has_blizz_powder", hasItem(reg.get("blizz_powder")))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(reg.get("lightning_tnt"))
                .key('G', Tags.Items.GUNPOWDER)
                .key('P', reg.get("blitz_powder"))
                .patternLine("GPG")
                .patternLine("PGP")
                .patternLine("GPG")
                .addCriterion("has_blitz_powder", hasItem(reg.get("blitz_powder")))
                .build(consumer);
    }

    private void generatePhytogroRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("phytogro"), 8)
                .addIngredient(Tags.Items.SAND)
                .addIngredient(fromTags(CoFHTags.Items.GEMS_APATITE, CoFHTags.Items.DUSTS_APATITE))
                .addIngredient(fromTags(CoFHTags.Items.GEMS_APATITE, CoFHTags.Items.DUSTS_APATITE))
                .addIngredient(fromTags(CoFHTags.Items.GEMS_NITER, CoFHTags.Items.DUSTS_NITER))
                .addCriterion("has_apatite", hasItem(reg.get("apatite")))
                .build(consumer, ID_THERMAL + ":phytogro_8");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("phytogro"), 4)
                .addIngredient(Tags.Items.SAND)
                .addIngredient(Items.BONE_MEAL)
                .addIngredient(fromTags(CoFHTags.Items.GEMS_APATITE, CoFHTags.Items.DUSTS_APATITE))
                .addIngredient(fromTags(CoFHTags.Items.GEMS_NITER, CoFHTags.Items.DUSTS_NITER))
                .addCriterion("has_apatite", hasItem(reg.get("apatite")))
                .build(consumer, ID_THERMAL + ":phytogro_4");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("phytogro"), 2)
                .addIngredient(Tags.Items.SAND)
                .addIngredient(Items.BONE_MEAL)
                .addIngredient(reg.get("rich_slag"))
                .addIngredient(fromTags(CoFHTags.Items.GEMS_NITER, CoFHTags.Items.DUSTS_NITER))
                .addCriterion("rich_slag", hasItem(reg.get("rich_slag")))
                .build(consumer, ID_THERMAL + ":phytogro_2");

        ShapedRecipeBuilder.shapedRecipe(reg.get("phyto_grenade"), 4)
                .key('G', Tags.Items.GUNPOWDER)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', reg.get("phytogro"))
                .patternLine("GPG")
                .patternLine("PIP")
                .patternLine("GPG")
                .addCriterion("has_phytogro", hasItem(reg.get("phytogro")))
                .build(consumer, ID_THERMAL + ":phyto_grenade_4");

        ShapedRecipeBuilder.shapedRecipe(reg.get("phyto_tnt"))
                .key('G', Tags.Items.GUNPOWDER)
                .key('P', reg.get("phytogro"))
                .patternLine("GPG")
                .patternLine("PGP")
                .patternLine("GPG")
                .addCriterion("has_phytogro", hasItem(reg.get("phytogro")))
                .build(consumer);
    }

    private void generateChargeRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        Item earthCharge = reg.get("earth_charge");
        Item iceCharge = reg.get("ice_charge");
        Item lightningCharge = reg.get("lightning_charge");

        ShapelessRecipeBuilder.shapelessRecipe(earthCharge, 3)
                .addIngredient(Tags.Items.GUNPOWDER)
                .addIngredient(reg.get("basalz_powder"))
                .addIngredient(Ingredient.fromItems(Items.COAL, Items.CHARCOAL))
                .addCriterion("has_basalz_powder", hasItem(reg.get("basalz_powder")))
                .build(consumer, ID_THERMAL + ":earth_charge_3");

        ShapelessRecipeBuilder.shapelessRecipe(iceCharge, 3)
                .addIngredient(Tags.Items.GUNPOWDER)
                .addIngredient(reg.get("blizz_powder"))
                .addIngredient(Ingredient.fromItems(Items.COAL, Items.CHARCOAL))
                .addCriterion("has_blizz_powder", hasItem(reg.get("blizz_powder")))
                .build(consumer, ID_THERMAL + ":ice_charge_3");

        ShapelessRecipeBuilder.shapelessRecipe(lightningCharge, 3)
                .addIngredient(Tags.Items.GUNPOWDER)
                .addIngredient(reg.get("blitz_powder"))
                .addIngredient(Ingredient.fromItems(Items.COAL, Items.CHARCOAL))
                .addCriterion("has_blitz_powder", hasItem(reg.get("blitz_powder")))
                .build(consumer, ID_THERMAL + ":lightning_charge_3");

        // region EARTH CHARGE CONVERSIONS
        ShapelessRecipeBuilder.shapelessRecipe(Items.PRISMARINE_SHARD, 4)
                .addIngredient(Items.PRISMARINE)
                .addIngredient(earthCharge)
                .addCriterion("has_prismarine", hasItem(Items.PRISMARINE))
                .build(consumer, ID_THERMAL + ":earth_charge/prismarine_shard_from_prismarine");

        ShapelessRecipeBuilder.shapelessRecipe(Items.PRISMARINE_SHARD, 9)
                .addIngredient(Items.PRISMARINE_BRICKS)
                .addIngredient(earthCharge)
                .addCriterion("has_prismarine_bricks", hasItem(Items.PRISMARINE_BRICKS))
                .build(consumer, ID_THERMAL + ":earth_charge/prismarine_shard_from_prismarine_bricks");

        ShapelessRecipeBuilder.shapelessRecipe(Items.QUARTZ, 4)
                .addIngredient(Items.QUARTZ_BLOCK)
                .addIngredient(earthCharge)
                .addCriterion("has_quartz_block", hasItem(Items.QUARTZ_BLOCK))
                .build(consumer, ID_THERMAL + ":earth_charge/quartz_from_quartz_block");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("diamond_dust"))
                .addIngredient(Tags.Items.GEMS_DIAMOND)
                .addIngredient(earthCharge)
                .addCriterion("has_diamond", hasItem(Tags.Items.GEMS_DIAMOND))
                .build(consumer, ID_THERMAL + ":earth_charge/diamond_dust_from_diamond");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("emerald_dust"))
                .addIngredient(Tags.Items.GEMS_EMERALD)
                .addIngredient(earthCharge)
                .addCriterion("has_emerald", hasItem(Tags.Items.GEMS_EMERALD))
                .build(consumer, ID_THERMAL + ":earth_charge/emerald_dust_from_emerald");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("ender_pearl_dust"))
                .addIngredient(Tags.Items.ENDER_PEARLS)
                .addIngredient(earthCharge)
                .addCriterion("has_ender_pearl", hasItem(Tags.Items.ENDER_PEARLS))
                .build(consumer, ID_THERMAL + ":earth_charge_ender_pearl_dust_from_ender_pearl");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("lapis_dust"))
                .addIngredient(Tags.Items.GEMS_LAPIS)
                .addIngredient(earthCharge)
                .addCriterion("has_lapis", hasItem(Tags.Items.GEMS_LAPIS))
                .build(consumer, ID_THERMAL + ":earth_charge/lapis_dust_from_lapis");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("quartz_dust"))
                .addIngredient(Tags.Items.GEMS_QUARTZ)
                .addIngredient(earthCharge)
                .addCriterion("has_quartz", hasItem(Tags.Items.GEMS_QUARTZ))
                .build(consumer, ID_THERMAL + ":earth_charge/quartz_dust_from_quartz");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("apatite_dust"))
                .addIngredient(CoFHTags.Items.GEMS_APATITE)
                .addIngredient(earthCharge)
                .addCriterion("has_apatite", hasItem(CoFHTags.Items.GEMS_APATITE))
                .build(consumer, ID_THERMAL + ":earth_charge/apatite_dust_from_apatite");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("cinnabar_dust"))
                .addIngredient(CoFHTags.Items.GEMS_CINNABAR)
                .addIngredient(earthCharge)
                .addCriterion("has_cinnabar", hasItem(CoFHTags.Items.GEMS_CINNABAR))
                .build(consumer, ID_THERMAL + ":earth_charge/cinnabar_dust_from_cinnabar");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("niter_dust"))
                .addIngredient(CoFHTags.Items.GEMS_NITER)
                .addIngredient(earthCharge)
                .addCriterion("has_niter", hasItem(CoFHTags.Items.GEMS_NITER))
                .build(consumer, ID_THERMAL + ":earth_charge/niter_dust_from_niter");

        ShapelessRecipeBuilder.shapelessRecipe(reg.get("sulfur_dust"))
                .addIngredient(CoFHTags.Items.GEMS_SULFUR)
                .addIngredient(earthCharge)
                .addCriterion("has_sulfur", hasItem(CoFHTags.Items.GEMS_SULFUR))
                .build(consumer, ID_THERMAL + ":earth_charge/sulfur_dust_from_sulfur");
        // endregion

        // region ICE CHARGE CONVERSIONS
        ShapelessRecipeBuilder.shapelessRecipe(Items.OBSIDIAN)
                .addIngredient(Items.LAVA_BUCKET)
                .addIngredient(iceCharge)
                .addCriterion("has_lava_bucket", hasItem(Items.LAVA_BUCKET))
                .build(consumer, ID_THERMAL + ":ice_charge/obsidian_from_lava_bucket");

        ShapelessRecipeBuilder.shapelessRecipe(Items.ICE)
                .addIngredient(Items.WATER_BUCKET)
                .addIngredient(iceCharge)
                .addCriterion("has_water_bucket", hasItem(Items.WATER_BUCKET))
                .build(consumer, ID_THERMAL + ":ice_charge/ice_from_water_bucket");
        // endregion

        // region LIGHTNING CHARGE CONVERSIONS
        ShapelessRecipeBuilder.shapelessRecipe(Items.WITCH_SPAWN_EGG)
                .addIngredient(Items.VILLAGER_SPAWN_EGG)
                .addIngredient(lightningCharge)
                .addCriterion("has_villager_spawn_egg", hasItem(Items.VILLAGER_SPAWN_EGG))
                .build(consumer, ID_THERMAL + ":lightning_charge/witch_from_villager");

        ShapelessRecipeBuilder.shapelessRecipe(Items.ZOMBIFIED_PIGLIN_SPAWN_EGG)
                .addIngredient(Items.PIG_SPAWN_EGG)
                .addIngredient(lightningCharge)
                .addCriterion("has_pig_spawn_egg", hasItem(Items.PIG_SPAWN_EGG))
                .build(consumer, ID_THERMAL + ":lightning_charge/zombified_piglin_from_pig");
        // endregion
    }
    // endregion
}
