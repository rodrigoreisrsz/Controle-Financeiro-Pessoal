const API_URL = "https://controle-financeiro-pessoal-wpzz.onrender.com";

function mostrarErroCadastro(mensagem) {
    const erro = document.getElementById("cadastroErro");
    erro.textContent = mensagem;
    erro.classList.add("modal__erro--visivel");
}

function esconderErroCadastro() {
    document.getElementById("cadastroErro").classList.remove("modal__erro--visivel");
}

async function fazerCadastro(event) {
    event.preventDefault();
    esconderErroCadastro();

    const nome = document.getElementById("cadastroNome").value;
    const senha = document.getElementById("cadastroSenha").value;

    try {
        const resposta = await fetch(`${API_URL}/user`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name: nome, password: senha }),
        });

        if (!resposta.ok) {
            const corpo = await resposta.text();
            throw new Error(`Erro ${resposta.status}: ${corpo || "sem detalhes retornados pela API"}`);
        }

        window.location.href = "login.html";
    } catch (erro) {
        mostrarErroCadastro(erro.message);
        console.error("[Cadastro] Falha:", erro);
    }
}

document.getElementById("formCadastro").addEventListener("submit", fazerCadastro);