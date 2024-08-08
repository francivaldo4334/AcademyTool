# AcademyTool
Sistema de de gestao para academias
## Fontes:
[Documentação do projeto](https://github.com/francivaldo4334/AcademyTool/blob/main/plano.pdf)
### Ajustes: 
 - linquagem-utilizada: kotlin
 - banco-de-dados: postgresql
 - altenticação: firebase
 - interface-grafica: jetpack compose
 - ide: jetbrais ou astroVim
### Requisitos adicionais:
 - Capacidade de identificar novas atualizações e atualizar automaticamente/opcinal caso o usuario queira.
 - Capacidade de customização de interface como cores e logo da academia.
 - Flexibilidae /criar perfis adicionais e customizados alem dos perfis predefinidos

## Configurando o ambiente
instalando o gerenciador de pacotes [SDKMAN](https://sdkman.io/install)
```bash
curl -s "https://get.sdkman.io" | bash && source "$HOME/.sdkman/bin/sdkman-init.sh
```
```bash
sdk version       

SDKMAN!
script: 5.18.2
native: 0.4.6
```
instalando o kotlin
```bash
sdk install kotlin
```
instalando o gradle
```bash
sdk install gradle
´´´
Construção o projeto
```bash
gradle init --type kotlin-application
```
##### java version: 21
##### project name: AcademyTool
##### select application structure:
 * 2: Application and library projet
##### select build script DSL:
 * 1: Kotlin<p>
##### generate buld using new APIs and behavior:
  * no<p>
#### Configuraçoes do AstroVim (Gradle)
```:LspInstall gradle```
```:TSInstall groovy```
##### edit ~/.config/nivm/init.lua
```lua
...

required'nvim-treesitter.configs'.setup{
  highlight = {
    enable = true,
    disable = { "kotlin" }
  }
}
```
