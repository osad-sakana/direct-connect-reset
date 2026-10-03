<div align="center">

# Direct Connect Reset

**ダイレクト接続画面を常に空欄で開き、貼り付け / リセットボタンを追加する、クライアントサイド専用 MOD**

[![Minecraft](https://img.shields.io/badge/Minecraft-26.2-62B47A)](https://www.minecraft.net/)
[![Fabric](https://img.shields.io/badge/Fabric_Loader-0.19.5-DBB69B)](https://fabricmc.net/)
[![Java](https://img.shields.io/badge/Java-25-007396)](https://adoptium.net/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

</div>

---

## ✨ 特長

| 機能 | 説明 |
| --- | --- |
| 🧹 **常に空欄で起動** | ダイレクト接続画面を開くと、前回の接続先は表示されず入力欄が空になります |
| 📋 **貼り付けボタン** | クリップボードの文字列を入力欄にセットします |
| ♻️ **リセットボタン** | 入力欄を空にします（入力欄が空のときは無効） |

> 🌐 **クライアントサイド専用** — サーバー側へのインストールは不要です。
> クリップボードの読み取りは「貼り付け」ボタンを押したときだけ行われ、通信は一切行いません。

---

## 📦 動作要件

- Minecraft **26.2**
- Fabric Loader **0.19.5** 以上 + Fabric API
- JDK **25**（ソースからビルドする場合）

---

## 🔨 ビルド

```bash
./gradlew build
```

生成された jar は `build/libs/` に出力されます。

## ▶️ 開発用クライアントの起動

```bash
./gradlew runClient
```

---

## 📄 ライセンス

[MIT](LICENSE) © osadsakana
