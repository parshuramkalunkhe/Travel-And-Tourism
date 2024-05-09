/**
 * 
 */

const testimonials = document.querySelectorAll('.testimonial');
let index = 0;

function showTestimonial() {
  testimonials.forEach(testimonial => testimonial.classList.remove('active'));
  testimonials[index].classList.add('active');
  index = (index + 1) % testimonials.length;
}

// Change slide every 5 seconds (adjust as needed)
setInterval(showTestimonial, 5000);
