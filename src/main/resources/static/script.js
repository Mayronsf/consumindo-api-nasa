document.getElementById('searchButton').addEventListener('click', function() {
    const date = document.getElementById('dateInput').value;
    if (!date) {
        alert("Por favor, escolha uma data.");
        return;
    }

    console.log("Data escolhida: " + date); // Log da data escolhida

    fetch(`/api/v1/nasa/data/date?arg0=${date}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Dados não encontrados ou erro na requisição');
            }
            return response.json();
        })
        .then(data => {
            displayResult(data);
        })
        .catch(error => {
            console.error('Erro:', error);
            document.getElementById('result').innerHTML = '<p style="color: red;">Erro ao buscar dados: ' + error.message + '</p>';
        });
});

function displayResult(data) {
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `
        <h2>${data.title}</h2>
        <p>${data.explanation}</p>
        <img src="${data.url}" alt="${data.title}">
        <p><strong>Data:</strong> ${data.date}</p>
    `;
}