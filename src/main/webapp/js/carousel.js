var slides = document.querySelectorAll('.slides img');
var currentSlide = 0;
var slideInterval = setInterval(nextSlide, 3000);

function nextSlide() {
  slides[currentSlide].style.transform = 'translateX(-100%)';
  currentSlide = (currentSlide + 1) % slides.length;
  slides[currentSlide].style.transform = 'translateX(0)';
}

function prevSlide() {
  slides[currentSlide].style.transform = 'translateX(100%)';
  currentSlide = (currentSlide - 1 + slides.length) % slides.length;
  slides[currentSlide].style.transform = 'translateX(0)';
}

var prevButton = document.querySelector('.prev');
var nextButton = document.querySelector('.next');

prevButton.addEventListener('click', function() {
  prevSlide();
  clearInterval(slideInterval);
  slideInterval = setInterval(nextSlide, 3000);
});

nextButton.addEventListener('click', function() {
  nextSlide();
  clearInterval(slideInterval);
  slideInterval = setInterval(nextSlide, 3000);
});
