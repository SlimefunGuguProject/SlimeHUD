# SlimeHUD

添加了 Slimefun 方块的 WAILA (我在看什么) 显示功能。  
你可以直接获得你看向的方块的名称，不需要打开菜单，或是破坏方块。  

可以在`config.yml`中设置使用BossBar或ActionBar显示。  
额外的能源/货运网络信息也可以设置开启或关闭。

玩家可以使用指令 `/slimehud toggle` 来切换 WAILA 的开关。

## 下载

[下载 SlimeHUD](https://resources.guizhanss.com/plugin/SlimeHUD)

## 预览

### BossBar 版本

<https://user-images.githubusercontent.com/101147426/180625208-4713a843-e856-475e-ba83-95b5a61786f8.mp4>

### ActionBar 版本

https://user-images.githubusercontent.com/101147426/180625211-cbcfd01d-d418-4e6c-a8ab-55d938d7840e.mp4

## PlaceholderAPI

- `%slimehud_toggle%` 返回玩家是否已启用 SlimeHUD。`true` 或 `false`。
- `%slimehud_hud%` 返回完整的的 HUD 显示文本，包含方块名称与额外信息
- `%slimehud_hud_block%` 仅包含方块名称
- `%slimehud_hud_block_info%` 仅包含额外信息

## 限制

- Minecraft 仅有7种颜色的 BossBar，而聊天文字颜色却有16种。

## 需要

- Spigot 或衍生服务端
- Slimefun

## Credits

*InfinityLib* by Mooy1
*Lombok* by Project Lombok
