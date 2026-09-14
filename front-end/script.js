// Dados de exemplo — depois isso vai vir da sua API (GET /registros)
const transacoes = [
  { nome: "Dividendos", categoria: "Investimentos", data: "2026-09-14", valor: 340, tipo: "entrada" },
  { nome: "Uber", categoria: "Transporte", data: "2026-09-12", valor: 87, tipo: "saida" },
  { nome: "Netflix + Spotify", categoria: "Assinaturas", data: "2026-09-10", valor: 65, tipo: "saida" },
  { nome: "Supermercado", categoria: "Alimentação", data: "2026-09-08", valor: 430, tipo: "saida" },
  { nome: "Freelance design", categoria: "Freelance", data: "2026-09-05", valor: 1200, tipo: "entrada" },
];

let filtroAtual = "todos";

function formatarMoeda(valor) {
  return valor.toLocaleString("pt-BR", { style: "currency", currency: "BRL" });
}

function formatarData(dataISO) {
  const [ano, mes, dia] = dataISO.split("-");
  return `${dia}/${mes}/${ano}`;
}

function calcularTotais(lista) {
  const entradas = lista
    .filter(t => t.tipo === "entrada")
    .reduce((soma, t) => soma + t.valor, 0);

  const saidas = lista
    .filter(t => t.tipo === "saida")
    .reduce((soma, t) => soma + t.valor, 0);

  return { entradas, saidas, saldo: entradas - saidas };
}

function renderResumo() {
  const { entradas, saidas, saldo } = calcularTotais(transacoes);
  const total = entradas + saidas;

  document.getElementById("saldoTotal").textContent = formatarMoeda(saldo);
  document.getElementById("totalEntradas").textContent = formatarMoeda(entradas);
  document.getElementById("totalSaidas").textContent = formatarMoeda(saidas);

  const percentEntradas = total > 0 ? Math.round((entradas / total) * 100) : 0;
  const percentSaidas = 100 - percentEntradas;

  document.getElementById("progressoBarra").style.width = `${percentEntradas}%`;
  document.getElementById("percentEntradas").textContent = `${percentEntradas}%`;
  document.getElementById("percentSaidas").textContent = `${percentSaidas}%`;
}

function renderLista() {
  const container = document.getElementById("listaTransacoes");
  container.innerHTML = "";

  const listaFiltrada = transacoes.filter(t =>
    filtroAtual === "todos" ? true : t.tipo === filtroAtual
  );

  listaFiltrada.forEach(t => {
    const item = document.createElement("li");
    item.className = "transacao";

    const sinal = t.tipo === "entrada" ? "+" : "-";
    const classeValor = t.tipo === "entrada" ? "valor--entrada" : "valor--saida";
    const classeMarcador = t.tipo === "entrada"
      ? "transacao__marcador--entrada"
      : "transacao__marcador--saida";

    item.innerHTML = `
      <span class="transacao__marcador ${classeMarcador}"></span>
      <div class="transacao__info">
        <p class="transacao__nome">${t.nome}</p>
        <p class="transacao__meta">${t.categoria} · ${formatarData(t.data)}</p>
      </div>
      <p class="transacao__valor ${classeValor}">${sinal}${formatarMoeda(t.valor)}</p>
    `;

    container.appendChild(item);
  });
}

function configurarTabs() {
  const tabs = document.querySelectorAll(".tab");

  tabs.forEach(tab => {
    tab.addEventListener("click", () => {
      tabs.forEach(t => t.classList.remove("tab--ativa"));
      tab.classList.add("tab--ativa");
      filtroAtual = tab.dataset.filtro;
      renderLista();
    });
  });
}

function init() {
  renderResumo();
  renderLista();
  configurarTabs();
}

init();
