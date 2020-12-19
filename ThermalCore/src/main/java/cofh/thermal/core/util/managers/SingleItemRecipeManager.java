package cofh.thermal.core.util.managers;

import cofh.core.fluid.IFluidStackAccess;
import cofh.core.inventory.IItemStackAccess;
import cofh.core.inventory.ItemStackHolder;
import cofh.core.util.ComparableItemStack;
import cofh.thermal.core.util.IThermalInventory;
import cofh.thermal.core.util.recipes.ThermalCatalyst;
import cofh.thermal.core.util.recipes.ThermalRecipe;
import cofh.thermal.core.util.recipes.internal.BaseMachineCatalyst;
import cofh.thermal.core.util.recipes.internal.IMachineRecipe;
import cofh.thermal.core.util.recipes.internal.IRecipeCatalyst;
import cofh.thermal.core.util.recipes.internal.SimpleMachineRecipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Simple recipe manager - single item key'd. Fluids NOT part of key.
 */
public abstract class SingleItemRecipeManager extends AbstractManager implements IRecipeManager {

    protected Map<ComparableItemStack, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();

    protected int maxOutputItems;
    protected int maxOutputFluids;

    protected SingleItemRecipeManager(int defaultEnergy, int maxOutputItems, int maxOutputFluids) {

        super(defaultEnergy);
        this.maxOutputItems = maxOutputItems;
        this.maxOutputFluids = maxOutputFluids;
    }

    public void addRecipe(ThermalRecipe recipe) {

        for (ItemStack recipeInput : recipe.getInputItems().get(0).getMatchingStacks()) {
            addRecipe(recipe.getEnergy(), recipe.getExperience(), Collections.singletonList(recipeInput), recipe.getInputFluids(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
        }
    }

    public boolean validRecipe(ItemStack input) {

        return getRecipe(input) != null;
    }

    protected void clear() {

        recipeMap.clear();
    }

    protected IMachineRecipe getRecipe(ItemStack input) {

        return getRecipe(Collections.singletonList(new ItemStackHolder(input)), Collections.emptyList());
    }

    protected IMachineRecipe getRecipe(List<? extends IItemStackAccess> inputSlots, List<? extends IFluidStackAccess> inputTanks) {

        if (inputSlots.isEmpty() || inputSlots.get(0).isEmpty()) {
            return null;
        }
        return recipeMap.get(convert(inputSlots.get(0).getItemStack()));
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> chance, List<FluidStack> outputFluids) {

        if (inputItems.isEmpty() || outputItems.isEmpty() && outputFluids.isEmpty() || outputItems.size() > maxOutputItems || outputFluids.size() > maxOutputFluids || energy <= 0) {
            return null;
        }
        ItemStack input = inputItems.get(0);
        if (input.isEmpty()) {
            return null;
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        for (FluidStack stack : outputFluids) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        energy = (int) (energy * getDefaultScale());

        SimpleMachineRecipe recipe = new SimpleMachineRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        recipeMap.put(convert(input), recipe);
        return recipe;
    }

    //    protected IMachineRecipe addRecipe(int energy, float experience, ItemStack input, ItemStack output) {
    //
    //        return addRecipe(energy, experience, Collections.singletonList(input), Collections.emptyList(), Collections.singletonList(output), Collections.singletonList(BASE_CHANCE_LOCKED), Collections.emptyList());
    //    }
    //
    //    protected IMachineRecipe addRecipe(int energy, float experience, ItemStack input, ItemStack output, float chance) {
    //
    //        return addRecipe(energy, experience, Collections.singletonList(input), Collections.emptyList(), Collections.singletonList(output), Collections.singletonList(chance), Collections.emptyList());
    //    }
    //
    //    protected IMachineRecipe addRecipe(int energy, float experience, ItemStack input, List<ItemStack> output, List<Float> chance) {
    //
    //        return addRecipe(energy, experience, Collections.singletonList(input), Collections.emptyList(), output, chance, Collections.emptyList());
    //    }

    // region IRecipeManager
    @Override
    public IMachineRecipe getRecipe(IThermalInventory inventory) {

        return getRecipe(inventory.inputSlots(), inventory.inputTanks());
    }

    @Override
    public List<IMachineRecipe> getRecipeList() {

        return new ArrayList<>(recipeMap.values());
    }
    // endregion

    // region CATALYZED CLASS
    public static abstract class Catalyzed extends SingleItemRecipeManager {

        protected Map<ComparableItemStack, IRecipeCatalyst> catalystMap = new Object2ObjectOpenHashMap<>();

        protected Catalyzed(int defaultEnergy, int maxOutputItems, int maxOutputFluids) {

            super(defaultEnergy, maxOutputItems, maxOutputFluids);
        }

        protected void clear() {

            super.clear();
            catalystMap.clear();
        }

        public List<ItemStack> getCatalysts() {

            List<ItemStack> ret = new ArrayList<>(catalystMap.size());
            catalystMap.keySet().forEach(stack -> ret.add(stack.toItemStack()));
            return ret;
        }

        // region CATALYSTS
        public IRecipeCatalyst getCatalyst(IItemStackAccess input) {

            return catalystMap.get(convert(input.getItemStack()));
        }

        public IRecipeCatalyst getCatalyst(ItemStack input) {

            return catalystMap.get(convert(input));
        }

        public void addCatalyst(ThermalCatalyst catalyst) {

            for (ItemStack ingredient : catalyst.getIngredient().getMatchingStacks()) {
                addCatalyst(ingredient, catalyst.getPrimaryMod(), catalyst.getSecondaryMod(), catalyst.getEnergyMod(), catalyst.getMinChance(), catalyst.getUseChance());
            }
        }

        public IRecipeCatalyst addCatalyst(ItemStack input, float primaryMod, float secondaryMod, float energyMod, float minChance, float useChance) {

            if (input == null || input.isEmpty()) {
                return null;
            }
            BaseMachineCatalyst catalyst = new BaseMachineCatalyst(primaryMod, secondaryMod, energyMod, minChance, useChance);
            catalystMap.put(convert(input), catalyst);
            return catalyst;
        }

        public boolean validCatalyst(ItemStack input) {

            return getCatalyst(input) != null;
        }

        public IRecipeCatalyst removeCatalyst(ItemStack input) {

            return catalystMap.remove(convert(input));
        }
        // endregion
    }
    // endregion
}
