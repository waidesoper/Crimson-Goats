package crimsonfluff.crimsongoats;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;

public class ConfigBuilder {
    public final ForgeConfigSpec SERVER;

    public ForgeConfigSpec.BooleanValue enableShearing;

    public ConfigBuilder() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder = new ForgeConfigSpec.Builder();
        builder.push("Goats");

        enableShearing = builder
            .comment("Enable the shearing of Goats.  Default: false")
            .define("enableShearing",false);

        builder.pop();
        SERVER = builder.build();
    }
}
