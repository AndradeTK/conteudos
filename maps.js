const fetch = require('node-fetch'); // use node-fetch ou fetch nativo no browser

const API_KEY = 'SUA_CHAVE_DE_API'; // Substitua pela sua chave de API

async function buscarCoordenadasEPontoNoMaps(nomePais) {
  const url = `https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(nomePais)}&key=${API_KEY}`;

  try {
    const response = await fetch(url);
    const data = await response.json();

    if (data.status === 'OK') {
      const location = data.results[0].geometry.location;
      const lat = location.lat;
      const lng = location.lng;

      console.log(`Coordenadas de ${nomePais}:`);
      console.log(`Latitude: ${lat}`);
      console.log(`Longitude: ${lng}`);

      const googleMapsLink = `https://www.google.com/maps?q=${lat},${lng}`;
      console.log(`Link do mapa: ${googleMapsLink}`);
    } else {
      console.log('Erro ao buscar dados:', data.status);
    }
  } catch (error) {
    console.error('Erro na requisição:', error);
  }
}

// Exemplo de uso:
buscarCoordenadasEPontoNoMaps('Brasil');
