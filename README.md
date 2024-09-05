# AcademyTool
Sistema de de gestao para academias
## Fontes:
[Documentação do projeto](https://github.com/francivaldo4334/AcademyTool/blob/main/plano.pdf)
## Links:
[UML](https://drive.google.com/open?id=1j39q4t9gAX8f0s3p4H_uaaiA-ZDBCr3I&usp=drive_copy)
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
 * 1: Single aplication
##### select build script DSL:
 * 1: Kotlin<p>
##### generate buld using new APIs and behavior:
  * no<p>
#### Configuraçoes do AstroVim (Gradle)
```:LspInstall gradle```
```:TSInstall groovy```
#### Configuraçoes do AstroVim (koltin)
```:LspInstall kotlin```
```:LspInstall kotlin_language_server```
##### edit ~/.config/nivm/init.lua
```lua
...

vim.api.nvim_set_keymap('n', '<leader>r', ':!./gradlew clean build run<CR>', { noremap = true, silent = true })

local lspconfig = require('lspconfig')

require('mason-lspconfig').setup{
  ensure_installed = { "kotlin_language_server" }
}

local lsp = require('lspconfig')

local function restart_lsp()
    for _, client in ipairs(vim.lsp.get_active_clients()) do
        client.stop()
        lsp[client.name].setup{}
    end
end

local function on_publish_diagnostics(_, result, _, _)
    for _, diagnostic in ipairs(result.diagnostics) do
        if diagnostic.severity == vim.lsp.protocol.DiagnosticSeverity.Error then
            if diagnostic.message:find("OutOfMemoryError") then
                restart_lsp()
                return
            end
        end
    end
end

vim.lsp.handlers['textDocument/publishDiagnostics'] = on_publish_diagnostics
lsp.kotlin_language_server.setup{
  -- cmd = { "sh", "-c", "fuser -k 50000/tcp && /home/higia/.kotlin_language_server/server/bin/kotlin-language-server --tcpServerPort 50000 & nc localhost 50000"},
  cmd = {"/home/higia/.kotlin_language_server/server/bin/kotlin-language-server"},
  filetype = { "kotlin" },
  root_dir = lsp.util.root_pattern("settings.gragle", "settings.gragle.kts", ".git"),
  on_attach = function(client, bufnr)
    -- client.server_capabilities.document_formatting = true
    -- client.server_capabilities.documentFormattingProvider = false
    -- client.server_capabilities.documentRangeFormattingProvider = false
    vim.api.nvim_set_keymap("n", "gD", "<cmd>lua vim.lsp.buf.declaration()<CR>", { noremap = true, silent = true })
    vim.api.nvim_set_keymap("n", "gd", "<cmd>lua vim.lsp.buf.definition()<CR>", { noremap = true, silent = true })
  end, 
}
```
```bash
export JAVA_OPTS="-Xmx2G"
kls
```
