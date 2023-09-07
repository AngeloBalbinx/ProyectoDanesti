const reviewsContainer = document.querySelector('#reviews-container');

const reviews = [
	{
		name: 'Juan Pérez',
		date: '15 de marzo de 2023',
		rating: 5,
		comment: 'La mejor pizza que he probado en mi vida. El sabor es espectacular y la masa está perfectamente hecha.',
		image: 'https://th.bing.com/th/id/R.539c1286cc082e1bd16e072700f81a43?rik=76hmpHGMaZ4C2g&pid=ImgRaw&r=0'
	},
	{
		name: 'María Gómez',
		date: '21 de marzo de 2023',
		rating: 4,
		comment: 'Muy buena pizza. La salsa de tomate es deliciosa y los ingredientes son frescos. La única cosa que no me gustó fue que la masa estaba un poco dura.',
		image: 'https://profile-images.xing.com/images/04ef35837cf66a5b180f35ff716cf886-4/andrea-kutjak.1024x1024.jpg'
	},
	{
		name: 'Pedro Torres',
		date: '2 de abril de 2023',
		rating: 3,
		comment: 'La pizza está bien, pero no es nada del otro mundo. Hay otros lugares que ofrecen pizzas similares a precios más bajos.',
		image: 'https://th.bing.com/th/id/R.d40fc79df9ea8f55fbef94f7da747ef6?rik=1BA1RLVeXRJ0DA&pid=ImgRaw&r=0'
	},
	{
		name: 'Ana López',
		date: '10 de abril de 2023',
		rating: 5,
		comment: 'Simplemente increíble. La pizza es deliciosa, el ambiente es acogedor y el servicio es excepcional. Definitivamente regresaré.',
		image: 'https://th.bing.com/th/id/R.1bdbea1adc755efaee6de42da2261a6d?rik=zrOuaoIL4w1QGg&pid=ImgRaw&r=0'
	},
	{
		name: 'Carlos Ramírez',
		date: '17 de abril de 2023',
		rating: 2,
		comment: 'No me gustó la pizza en absoluto. El queso estaba demasiado grasoso y la masa estaba cruda en algunos lugares.',
		image: 'https://4.bp.blogspot.com/_M9sYaPxvKw0/TUzOUoRToPI/AAAAAAAAGKg/oYhEn8pgE-4/s1600/001.JPG'
	},
];

function showReviews() {
	reviewsContainer.innerHTML = '';

	for (let review of reviews) {
		const reviewElement = document.createElement('div');
		reviewElement.classList.add('review');

		const imageElement = document.createElement('img');
		imageElement.src = review.image;
		imageElement.alt = review.name;
       imageElement.classList.add('review-image');
		reviewElement.appendChild(imageElement);

		const ratingElement = document.createElement('div');
		ratingElement.classList.add('rating');
		ratingElement.textContent = `${review.rating} estrellas`;
		reviewElement.appendChild(ratingElement);

		const nameElement = document.createElement('div');
		nameElement.classList.add('name');
		nameElement.textContent = review.name;
		reviewElement.appendChild(nameElement);

		const dateElement = document.createElement('div');
		dateElement.classList.add('date');
		dateElement.textContent = review.date;
		reviewElement.appendChild(dateElement);

		const commentElement = document.createElement('div');
		commentElement.classList.add('comment');
		commentElement.textContent = review.comment;
		reviewElement.appendChild(commentElement);

		reviewsContainer.appendChild(reviewElement);
        
        
	}
}

showReviews();



