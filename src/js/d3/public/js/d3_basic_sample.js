(function() {
	"use strict";

	function add_bg() {
		let color_bg = document.getElementById('color_bg').value;
		d3.select("#BACK_GROUND_COLOR")
		    .style("background-color",color_bg);
	}

	function add_color() {
		let color_text = document.getElementById('color_text').value;
		d3.select("#TEXT1").selectAll("p").style("color", color_text);
	}

	function add_color_random() {
		d3.select("#TEXT2").selectAll("p").style("color", () => {
			return "hsl(" + Math.random() * 360 + ", 100%,50%)";
		});
	}
	
	function change_font_size() {
		d3.select("#TEXT2").selectAll("p")
		.data([10, 12, 14])
		.style("font-size", (d) => {
			return d + "px";
		});
	}
	
	function add_word() {
		let p = d3.select("#TEXT2").selectAll("p")
		.data(["hogehoge", "fugafuga", "piyopiyo", "", "", "", "hoge", "fuga", "piyo"])
		.text((d) => d);
		p.enter().append("li").text((d) => d);
	}
	
	function transition_bg() {
        let text_bg = document.getElementById('text_bg').value;
		d3.selectAll("#TEXT2")
		.transition().duration(750)
		.delay((d,i) => i * 10)
		.style("background-color", text_bg);
	}

	function load() {
		let bg_button = document.getElementById('bg_button'),
		text_button1 = document.getElementById('text_button1'),
		text_button2 = document.getElementById('text_button2'),
		test_button_change = document.getElementById('test_button_change'),
		test_button_add = document.getElementById('test_button_add'),
		text_button_bg = document.getElementById('text_button_bg')
		;
		bg_button.addEventListener('click', add_bg, false);
		text_button1.addEventListener('click', add_color, false);
		text_button2.addEventListener('click', add_color_random, false);
		test_button_change.addEventListener('click', change_font_size, false);
		test_button_add.addEventListener('click', add_word, false);
		text_button_bg.addEventListener('click', transition_bg, false);
	}
	document.addEventListener('DOMContentLoaded', load, false);
}());
