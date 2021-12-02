package crimsonfluff.crimsongoats;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigBuilder {
    public final ForgeConfigSpec SERVER;

    public ForgeConfigSpec.BooleanValue enableShearing;

    public ConfigBuilder() {
        ForgeConfigSpec.Builder builder;

        builder = new ForgeConfigSpec.Builder();
        builder.push("Goats");

        enableShearing = builder
            .comment("Enable the shearing of Goats.  Default: true")
            .define("enableShearing",true);

        builder.pop();
        SERVER = builder.build();
    }
}
