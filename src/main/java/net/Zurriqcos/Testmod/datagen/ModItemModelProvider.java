package net.Zurriqcos.Testmod.datagen;

import net.Zurriqcos.Testmod.ExampleMod;
import net.Zurriqcos.Testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, ExampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.Item1.get());
        basicItem(ModItems.Item2.get());
        basicItem(ModItems.Item3.get());
        basicItem(ModItems.ABADLLETA.get());
    }
}
