package su.nightexpress.nightcore.bridge.components;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ResolvableProfile;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public record ProfileComponent(String uuid, String name) {
    public static ProfileComponent getFromDataComponent(ResolvableProfile profile) {
        return new ProfileComponent(profile.uuid().toString(), profile.name());
    }

    public void apply(ItemStack item) {
        PlayerProfile profile = Bukkit.createProfile(UUID.fromString(uuid), name);
        item.setData(DataComponentTypes.PROFILE, ResolvableProfile.resolvableProfile(profile));
    }
}
