package io.github.zeettn.wjplugin

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import saveDataToYAML

class AddTpCommandHandler(private val plugin: JavaPlugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("플레이어만 이 명령어를 사용할 수 있습니다.")
            return true
        }

        if (args.isEmpty()) {
            sender.sendMessage("저장할 위치의 이름을 입력하세요. 예: /addtp <이름>")
            return true
        }

        val location: Location = sender.location
        val key = args[0]

        saveDataToYAML(plugin, key, location)
        sender.sendMessage("텔레포트 위치 '$key' 가 저장되었습니다.")

        return true
    }
}