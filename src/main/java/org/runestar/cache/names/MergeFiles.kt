package org.runestar.cache.names

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val uniqueNameHashes = File("name-hashes.tsv").readLines().mapTo(HashSet()) { it.split('\t').last().toInt() }

    val individualNames = File("individual-names.tsv").readLines().toSortedSet()
    Files.write(Paths.get("individual-names.tsv"), individualNames)

    val knownNames = ArrayList<String>(individualNames)

    fun String.add() {
        if (hashCode() in uniqueNameHashes) {
            knownNames.add(this)
        }
    }

    for (x in 0..255) {
        for (y in 0..255) {
            "m${x}_$y".add()
            "l${x}_$y".add()
        }
        "emotes,$x".add()
        "emotes_locked,$x".add()
        "tabs,$x".add()
        "orb_xp,$x".add()
        "reset,$x".add()
        "options_radio_buttons,$x".add()
        "zeah_book,$x".add()
        "magicon,$x".add()
        "magicon2,$x".add()
        "combaticons,$x".add()
        "combaticons2,$x".add()
        "combaticons3,$x".add()
        "hitmark,$x".add()
        "peng_emotes,$x".add()
        "staticons,$x".add()
        "staticons2,$x".add()
        "barbassault_icons,$x".add()
        "orb_icon,$x".add()
        "options_icons,$x".add()
        "options_slider,$x".add()
        "ge_icons,$x".add()
        "warning_icons,$x".add()
        "close_buttons,$x".add()
        "side_icons,$x".add()
        "steelborder,$x".add()
        "steelborder2,$x".add()
        "arrow,$x".add()
        "magicoff,$x".add()
        "magicoff2,$x".add()
        "miscgraphics,$x".add()
        "miscgraphics2,$x".add()
        "miscgraphics3,$x".add()
        "prayeroff,$x".add()
        "combatboxes,$x".add()
        "prayeron,$x".add()
        "mapfunction,$x".add()
        "sworddecor,$x".add()
        "wornicons,$x".add()
        "clickcross,$x".add()
        "worldmap_icon,$x".add()
        "bankbuttons,$x".add()
        "scrollbar_v2,$x".add()
        "scrollbar_dragger_v2,$x".add()
        "fast_forward,$x".add()
        "thumbs,$x".add()
        "checkbox,$x".add()
        "open_buttons,$x".add()
        "banktabs,$x".add()
        "options_boxes,$x".add()
        "mobile_stones,$x".add()
        "tabs_large,$x".add()
        "2x_standard_spells_on,$x".add()
        "2x_standard_spells_off,$x".add()
        "2x_lunar_spells_on,$x".add()
        "2x_lunar_spells_off,$x".add()
        "2x_ancient_spells_on,$x".add()
        "2x_ancient_spells_off,$x".add()
        "2x_necro_spells_on,$x".add()
        "2x_necro_spells_off,$x".add()
        "wint_icons,$x".add()
        "magic_necro_on,$x".add()
        "magic_necro_off,$x".add()
        "v2_stone_button,$x".add()
        "v2_stone_button_in,$x".add()
        "v2_stone_borders,$x".add()
        "med_buttons,$x".add()
        "lunar_magic_on,$x".add()
        "lunar_magic_off,$x".add()
        "achievement_diary_icons,$x".add()
        "ii_impling_icons,$x".add()
        "orb_filler,$x".add()
        "windowmode_icons,$x".add()
        "ge_smallicons,$x".add()
        "sideicons_new,$x".add()
        "options_icons_small,$x".add()
        "gnomeball_buttons,$x".add()
        "orb_frame,$x".add()
        "poh_doors,$x".add()
        "banktabs_small,$x".add()
        "ge_cancel,$x".add()
        "banktab_icons,$x".add()
        "orb_frame,$x".add()
        "sortarrows,$x".add()
        "clan_chat_buttons,$x".add()
        "tabs_split,$x".add()
        "scrollbar_sep,$x".add()
        "oge_images,$x".add()
        "oge_title,$x".add()
        "close_buttons_v2,$x".add()
        "pvpw_icons,$x".add()
        "sideicons_interface,$x".add()
        "miscgraphics4,$x".add()
        "cross_interface,$x".add()
        "red_green_arrows,$x".add()
        "worldmap_icon_large,$x".add()
        "steelborder_close_button,$x".add()
        "headicons_pk_interface,$x".add()
        "mapdots_interface,$x".add()
        "clan_chat_icons,$x".add()
        "combatboxesmed,$x".add()
        "combatboxes_large,$x".add()
        "combatboxes_split,$x".add()
    }

    val knownNamesMap = knownNames.associateBy { it.hashCode() }

    val fullNames = File("name-hashes.tsv").readLines().map { line ->
        val hash = line.split('\t').last().toInt()
        val name = knownNamesMap.getOrDefault(hash, "")
        "$line\t$name"
    }
    Files.write(Paths.get("names.tsv"), fullNames)
}