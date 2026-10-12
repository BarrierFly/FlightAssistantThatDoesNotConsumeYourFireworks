<p align=center>
    <img src="images/logo.png">
</p>

<p align=center>
    <a href="https://modrinth.com/mod/flightassistant">
        <img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/available/modrinth_vector.svg"
            alt="Available on Modrinth"></a>
    <a href="https://modrinth.com/mod/fabric-api/">
        <img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/requires/fabric-api_vector.svg"
            alt="Requires Fabric API"></a>
    <a href="https://modrinth.com/mod/flightassistant/versions?l=forge&l=neoforge">
        <img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/supported/forge_vector.svg"
            alt="Available for Forge"></a>
    <a href="https://discord.gg/5kcBCvnbTp">
        <img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/social/discord-plural_vector.svg"
            alt="Chat with us on Discord"></a>
</p>

---

## 关于本仓库 / About this fork

本仓库是 [Octol1ttle/FlightAssistant](https://github.com/Octol1ttle/FlightAssistant) 的 fork，与上游的主要区别如下：

- **自动驾驶不再自动消耗你的烟花**：移除了自动驾驶自动发射烟花作为推力来源的逻辑。烟花的使用完全由玩家手动控制；烟花安全锁（爆炸烟花/前方有障碍物时禁止右键使用）与烟花数量显示等安全功能均予保留。
- **临时禁用 Forge / NeoForge 构建**：目前只构建 Fabric 版本（1.20.1 / 1.21.1 / 1.21.6 / 1.21.9 / 1.21.11）。如需恢复 Forge 系构建，参见 `settings.gradle.kts` 中的注释。

This repository is a fork of [Octol1ttle/FlightAssistant](https://github.com/Octol1ttle/FlightAssistant). The main differences from upstream are:

- **The autopilot no longer consumes your fireworks**: the logic that made the autopilot automatically fire fireworks as a thrust source has been removed. Fireworks are now used purely manually; the safety features — the firework locks (right-clicking is blocked while holding explosive fireworks or when terrain is ahead) and the firework count HUD status — are kept intact.
- **Forge / NeoForge builds are temporarily disabled**: only Fabric targets (1.20.1 / 1.21.1 / 1.21.6 / 1.21.9 / 1.21.11) are currently built. See the comment in `settings.gradle.kts` to restore them.

---

**FlightAssistant** is a powerful client-side mod that adds fully configurable full-fledged avionics, situational awareness tools and advanced automation to Minecraft elytras, while still being friendly to casual users. 

## Main Features

- Fully customizable flight HUD ([wiki](https://github.com/Octol1ttle/FlightAssistant/wiki/HUD))
  - An informative display showing flight data in real time
    <img src="https://github.com/Octol1ttle/FlightAssistant/wiki/img/hud/full_screenshot_alt.png">
- Smart flight safety alerts ([wiki](https://github.com/Octol1ttle/FlightAssistant/wiki/Alerts))
  - Be aware of unsafe flight conditions before it's too late
    <img src="https://github.com/Octol1ttle/FlightAssistant/wiki/img/hud/alert_display_alt.png">
- Non-intrusive automatic flight protections ([wiki](https://github.com/Octol1ttle/FlightAssistant/wiki/Flight-protections))
  - When you're not paying attention, FlightAssistant will protect you
  - Examples: ground collision damage avoidance, void damage avoidance, automatic elytra deploying
- Advanced autopilot with flight planning capabilities: fly safely completely hands-free ([wiki](https://github.com/Octol1ttle/FlightAssistant/wiki/Autopilot%3A-overview-and-basics))
  - Flight plans can be saved to disk and loaded later
  - With flight plans, a flight can be performed completely automatically from takeoff to landing
    <img src="https://github.com/Octol1ttle/FlightAssistant/wiki/img/hud/full_screenshot.png">