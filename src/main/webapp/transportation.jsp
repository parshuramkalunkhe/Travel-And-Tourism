<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transportation</title>

<link rel="stylesheet" href="css/styles.css">
</head>
<style>
main {
	padding: 20px;
}

.transportation {
	display: flex;
	margin-bottom: 20px;
}

.image {
	flex: 1;
	margin-right: 20px;
}

.image img {
	width: 100%;
	height: auto;
}

.details {
	flex: 2;
}

.details h2 {
	margin-top: 0;
}

.description {
	margin-top: 5px;
}
</style>
<body>

	<%@ include file="components/banner.jsp"%>
	<%@ include file="components/header.html"%>
	<main>
		<section class="transportation">
			<div class="image">
				<img src="https://images.unsplash.com/photo-1544620347-c4fd4a3d5957?q=80&w=1469&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Transportation Image">
			</div>
			<div class="details">
				<h2>Train</h2>
				<p class="description">Trains are a convenient and eco-friendly
					way to travel long distances. Sit back, relax, and enjoy the scenic
					views as you journey to your destination.</p>
			</div>
		</section>
		<section class="transportation">
			<div class="image">
				<img src="https://images.unsplash.com/photo-1544620347-c4fd4a3d5957?q=80&w=1469&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Transportation Image">
			</div>
			<div class="details">
				<h2>Bus</h2>
				<p class="description">Buses are a cost-effective mode of
					transportation, offering flexibility and accessibility to various
					destinations. Explore cities, towns, and countryside aboard a
					comfortable bus.</p>
			</div>
		</section>
		<section class="transportation">
			<div class="image">
				<img src="https://images.unsplash.com/photo-1544620347-c4fd4a3d5957?q=80&w=1469&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Transportation Image">
			</div>
			<div class="details">
				<h2>Car Rental</h2>
				<p class="description">Renting a car provides the freedom to
					travel at your own pace and explore off-the-beaten-path
					destinations. Discover hidden gems and picturesque landscapes with
					the convenience of a rental car.</p>
			</div>
		</section>
	</main>
	<%@ include file="components/footer.html"%>
</body>
</html>