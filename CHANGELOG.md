# Changelog

このプロジェクトのすべての注目すべき変更を記録します。

フォーマットは [Keep a Changelog](https://keepachangelog.com/ja/1.1.0/) に準拠し、
バージョニングは [Semantic Versioning](https://semver.org/lang/ja/) に従います。

## [1.0.2] - 2026-10-03

### Fixed
- v1.0.1 でボタンのラベルが翻訳キーのまま表示される不具合を修正。言語ファイルの読み込みに Fabric API（fabric-resource-loader）が必要なため、Fabric API への依存を復活（`fabric.mod.json` にも `fabric-api` を明記）。

## [1.0.1] - 2026-10-03

### Added
- MOD アイコンを追加。

### Changed
- 使用していなかった Fabric API への依存をビルドと動作要件から削除（Fabric Loader のみで動作）。
- CI の `actions/setup-java` を v5 に更新。

## [1.0.0] - 2026-10-03

初回リリース。Minecraft 26.2 / Fabric Loader 0.19.5 対応。

### Added
- ダイレクト接続画面を開いたとき、入力欄を常に空欄にする。
- 入力欄の下に「貼り付け」ボタン（クリップボードの内容を入力欄へセット）を追加。
- 入力欄の下に「リセット」ボタン（入力欄を空にする。空のときは無効）を追加。
- 日本語 / 英語のローカライズ。
