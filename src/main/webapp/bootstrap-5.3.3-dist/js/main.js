const scrolls = document.querySelectorAll(".scroll");

scrolls.forEach((item) =>
	item.addEventListener("click", function() {
		console.log("Hello");
		const element = item.getElementsByClassName("item-scroll")[0];
		if (element.style.height != "0px") {
			element.style.height = 0 + "px";
		} else {
			element.style.height = element.scrollHeight + "px";
		}
	})
);

const ghes = document.querySelectorAll(".checkghe");
ghes.forEach((item) => {
	item.addEventListener("click", function(e) {
		if (item.classList.contains("checkghe-active")) {
			item.classList.remove("checkghe-active");
		} else {

			item.classList.add("checkghe-active");
		}

	});
});



const radioChecks = document.querySelectorAll(".radioCheck");
radioChecks.forEach((item) => {
	item.addEventListener("click", function(e) {
		radioChecks.forEach((i) => {
			i.classList.remove("checkghe-active");
		});
		if (item.classList.contains("checkghe-active")) {
			item.classList.remove("checkghe-active");
		} else {
			item.classList.add("checkghe-active");
		}

	});
});

const checkPhims = document.querySelectorAll(".checkphim");
checkPhims.forEach((item) => {
	item.addEventListener("click", function(e) {
		checkPhims.forEach((i) => {
			i.classList.remove("border");
			i.classList.remove("p-2");
			i.classList.remove("rounded-2");
		});
		if (item.classList.contains("border")) {
			item.classList.remove("border");
			item.classList.remove("p-2");
			item.classList.remove("rounded-2");
		} else {
			item.classList.add("border");
			item.classList.add("p-2");
			item.classList.add("rounded-2");
		}

	});
});


function agree() {
	const checkbox = document.querySelector("#checkboxAgree");
	if (checkbox.isChecked) {
		document.querySelector("#buttonDangky").disabled = false;
	} else {
		document.querySelector("#buttonDangky").disabled = true;
	}
}
window.onload = () => {
	if (errorLogin) {
		const myModal = new bootstrap.Modal('#modalLogin');
		myModal.show();
	} else if (errorRegister) {
		const myModal = new bootstrap.Modal('#modalRegister');
		myModal.show();
	}
}


