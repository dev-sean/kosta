<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<link rel="stylesheet" href="style/style.css" type="text/css">
<style>
</style>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<div id="wrap">
		<header>
			<h1>Include ����</h1>
			<h2>Include �������� top.jsp ����</h2>
		</header>
		<nav>
			<ul>
				<li><a href="">�޴�1</a></li>
				<li><a href="">�޴�1</a></li>
				<li><a href="">�޴�1</a></li>
				<li><a href="">�޴�1</a></li>
				<li><a href="">�޴�1</a></li>
				<li><a href="">�޴�1</a></li>
				<li><a href="">�޴�1</a></li>
				<li><a href="">�޴�1</a></li>
			</ul>
		</nav>
		<article>
			<header>
				<h2>����� �������� ����1</h2>
			</header>

			<p>Apps provide multiple entry points Android apps are built as a
				combination of distinct components that can be invoked individually.
				For instance, an individual activity provides a single screen for a
				user interface, and a service independently performs work in the
				background. From one component you can start another component using
				an intent. You can even start a component in a different app, such
				an activity in a maps app to show an address. This model provides
				multiple entry points for a single app and allows any app to behave
				as a user's "default" for an action that other apps may invoke.</p>
			<section>
				<header>
					<h2>����� �������� ����2</h2>
				</header>
				<p>Apps adapt to different devices Android provides an adaptive
					app framework that allows you to provide unique resources for
					different device configurations. For example, you can create
					different XML layout files for different screen sizes and the
					system determines which layout to apply based on the current
					device's screen size. You can query the availability of device
					features at runtime if any app features require specific hardware
					such as a camera. If necessary, you can also declare features your
					app requires so app markets such as Google Play Store do not allow
					installation on devices that do not support that feature.</p>
			</section>
		</article>
		<footer>
			<nav>
				<ul>
					<li><a href="">�޴�1</a></li>
					<li><a href="">�޴�1</a></li>
					<li><a href="">�޴�1</a></li>
					<li><a href="">�޴�1</a></li>
					<li><a href="">�޴�1</a></li>
					<li><a href="">�޴�1</a></li>
					<li><a href="">�޴�1</a></li>
					<li><a href="">�޴�1</a></li>
				</ul>
			</nav>
		</footer>
	</div>
</body>
</html>