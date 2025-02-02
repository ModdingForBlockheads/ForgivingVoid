package net.blay09.mods.forgivingvoid;

import net.blay09.mods.balm.api.config.BalmConfigData;
import net.blay09.mods.balm.api.config.Comment;
import net.blay09.mods.balm.api.config.Config;
import net.blay09.mods.balm.api.config.ExpectedType;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Config(ForgivingVoid.MOD_ID)
public class ForgivingVoidConfigData implements BalmConfigData {

    @Comment("The distance to the minimum y level at which Forgiving Void should forgive the player and send them towards the sky.")
    public int triggerAtDistanceBelow = 32;

    @Comment("The amount of damage applied to the player when they land.")
    public int damageOnFall = 19;

    @Comment("The height from which the player will be falling after falling through the void.")
    public int fallingHeight = 300;

    @Comment("Set to true to make Forgiving Void return the player to the sky above their last grounded position instead of their current position. Prevents players from using Forgiving Void to fly across larger distances.")
    public boolean returnToLastGrounded = true;

    @Comment("Prevent death on void fall (limits damage to leave at least 0.5 hearts)")
    public boolean preventDeath = false;

    @Comment("Set to false to make Forgiving Void not trigger in the overworld void (dimension 0).")
    public boolean triggerInOverworld = true;

    @Comment("Set to false to make Forgiving Void not trigger in the nether void (dimension -1).")
    public boolean triggerInNether = true;

    @Comment("Set to false to make Forgiving Void not trigger in the end void (dimension 1).")
    public boolean triggerInEnd = true;

    @Comment("Set to true if players are rubber-banding while falling through the void. If you're hosting a public server, you should only do this if you have proper anti-cheat installed.")
    public boolean disableVanillaAntiCheatWhileFalling = true;

    @Comment("Set to true to have tridents with loyalty be affected by Forgiving Void. Not supported on Forge.")
    public boolean tridentForgiveness = false;

    @ExpectedType(String.class)
    @Comment("Effects applied to a player when they fall through the void, in the format \"effect|duration|amplifier\"")
    public List<String> fallThroughVoidEffects = List.of("minecraft:blindness|60|3");

    @Comment("List of dimension ids to be allowed for Forgiving Void. Options triggerInOverworld etc. take priority.")
    @ExpectedType(ResourceLocation.class)
    public Set<ResourceLocation> dimensionAllowList = new HashSet<>();

    @Comment("List of additional dimension ids to be deny-listed from Forgiving Void. Options triggerInOverworld etc. take priority. Ignored if dimensionAllowList is set.")
    @ExpectedType(ResourceLocation.class)
    public Set<ResourceLocation> dimensionDenyList = new HashSet<>();

    @Comment("List of entity ids to be allowed for Forgiving Void. On Forge this only supports living entities.")
    @ExpectedType(ResourceLocation.class)
    public Set<ResourceLocation> entityAllowList = Set.of(ResourceLocation.withDefaultNamespace("player"));

}
