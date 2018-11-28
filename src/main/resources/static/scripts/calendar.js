var monthNames = [
	"January",
	"February",
	"March",
	"April",
	"May",
	"June",
	"July",
	"August",
	"September",
	"October",
	"November",
	"December",
]

window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar-Calendar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}

function getSelectedYear() {
	const selectedYearString = document.getElementById("selectedYear").innerHTML;
	return parseInt(selectedYearString, 10);
}

function getSelectedMonth() {
	const selectedMonthString = document.getElementById("selectedMonth").innerHTML;
	return parseInt(selectedMonthString, 10);
}


function hideMonth(month) {
	const element = document.getElementById(`month-${month}`);
	element.classList.remove("show");
}

function showMonth(month) {
	const element = document.getElementById(`month-${month}`);
	element.classList.add("show");
}

function setSelectedMonth(lastMonth, nextMonth) {
	const selectedMonthHeading = document.getElementById("selectedMonthHeading");
	const selectedMonth = document.getElementById("selectedMonth");
	selectedMonth.innerHTML = `${month}`;
	selectedMonthHeading.innerHTML = `${monthNames[month]}`;
	
	hideMonth(lastMonth)
	showMonth(nextMonth)
}

function setSelectedYear(year) {
	const selectedYearHeading = document.getElementById("selectedYearHeading");
	const selectedYear = document.getElementById("selectedYear");
	selectedYear.innerHTML = `${year}`;
	selectedYearHeading.innerHTML = `${year}`;
}

function showNextMonth() {
	const lastMonth = getSelectedMonth();
	const possibleNextMonth = lastMonth + 1;
	let year = getSelectedYear(); 
	if (possibleNextMonth > 11) {
		year += 1;
	}
	const nextMonth = possibleNextMonth % 12;
	
	setSelectedYear(year);
	setSelectedMonth(lastMonth, nextMonth);
}

document.addEventListener("DOMContentLoaded", function() {
 	const nextButton = document.getElementById("nextButton");
 	const prevButton = document.getElementById("prevButton");
});

