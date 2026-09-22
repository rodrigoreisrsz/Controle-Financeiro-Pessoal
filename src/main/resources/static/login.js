const API_URL = "https://controle-financeiro-pessoal-wpzz.onrender.com";

function mostrarErroLogin(mensagem) {
    const erro = document.getElementById("loginErro");
    erro.textContent = mensagem;
    erro.classList.add("modal__erro--visivel");
}

function esconderErroLogin() {
    document.getElementById("loginErro").classList.remove("modal__erro--visivel");
}

async function fazerLogin(event) {
    event.preventDefault();
    esconderErroLogin();

    const nome = document.getElementById("loginNome").value;
    const senha = document.getElementById("loginSenha").value;

    try {
        const resposta = await fetch(`${API_URL}/user/login`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name: nome, password: senha }),
        });

        if (!resposta.ok) {
            throw new Error("Usuário ou senha inválidos.");
        }

        const usuario = await resposta.json();
        localStorage.setItem("usuarioId", usuario.id);
        window.location.href = "index.html";
    } catch (erro) {
        mostrarErroLogin(erro.message);
    }
}

document.getElementById("formLogin").addEventListener("submit", fazerLogin);