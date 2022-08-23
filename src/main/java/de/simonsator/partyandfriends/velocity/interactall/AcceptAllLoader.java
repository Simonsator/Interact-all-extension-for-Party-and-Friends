package de.simonsator.partyandfriends.velocity.interactall;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;

import java.nio.file.Path;

@Plugin(id = "ia-for-paf", name = "IA-For-PAF", version = "1.0.5-RELEASE",
		url = "https://www.spigotmc.org/resources/interact-all-extension-for-party-and-friends-for-bungeecord-spigot.29495/",
		description = "An add-on for party and friends to add /friend acceptall and /friend denyall",
		authors = {"JT122406", "Simonsator"}, dependencies = {@Dependency(id = "partyandfriends")})
public class AcceptAllLoader {

	private final Path folder;

	@Inject
	public AcceptAllLoader(@DataDirectory final Path folder) {
		this.folder = folder;
	}

	@Subscribe
	public void onProxyInitialization(ProxyInitializeEvent event) {
		PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new IAMain(folder),
				"ia-for-paf",
				"IA-For-PAF",
				"1.0.5-RELEASE", "JT122406, Simonsator"));
	}

}
