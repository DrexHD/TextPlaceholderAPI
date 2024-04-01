package eu.pb4.placeholders.mixin;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MutableText.class)
public abstract class MutableTextMixin {

    @Shadow
    public abstract MutableText append(Text... texts);

    // Adds back the intermediary of MutableText.append(Text text)
    // to ensure mods that are using this method work without recompiling
    public MutableText method_10852(Text text) {
        this.append(text);
        return (MutableText) (Object) this;
    }

}
