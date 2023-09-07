// Obtener el elemento footer
const footer = document.querySelector('footer');

// Función para animar el footer
function animateFooter() {
  // Obtener la posición actual del footer
  const footerTop = footer.getBoundingClientRect().top;

  // Obtener la altura de la ventana
  const windowHeight = window.innerHeight;

  // Si el footer está visible en la ventana
  if (footerTop < windowHeight) {
    // Agregar la clase 'visible' al footer
    footer.classList.add('visible');
  } else {
    // Remover la clase 'visible' del footer
    footer.classList.remove('visible');
  }
}

// Llamar a la función animateFooter cuando la página se cargue y se desplace
window.addEventListener('load', animateFooter);
window.addEventListener('scroll', animateFooter);
