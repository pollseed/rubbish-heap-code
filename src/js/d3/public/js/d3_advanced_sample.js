(function() {
	"use strict";
	const DATASET1 = [ 1, 5, 10, 15, 20, 25  ],
				DATASET2 = [ [5, 20], [480, 90], [250, 50], [100, 33], [330, 95],
					            [410, 12], [475, 44], [25, 67], [85, 21], [220, 88],
											[600, 150] ],
											svg_w = 500, bar_padding = 1, padding = 30;

	non_scale();

	on_scale();

	function on_scale() {
		let dataset = [],
			num_data_points = 50,
			x_range = Math.random() * 1000,
			y_range = Math.random() * 1000,
			new_number1, new_number2,
			svg_h = 300;
		for (let i = 0; i < num_data_points; i++) {
			new_number1 = Math.round(Math.random() * x_range),
			new_number2 = Math.round(Math.random() * y_range);
			dataset.push([new_number1, new_number2]);
		}
		let x_scale = d3.scale.linear();
		x_scale
			.domain([0, d3.max(dataset, d => d[0])])
			.range([padding, svg_w - padding * 2.5]);
		let y_scale = d3.scale.linear();
		y_scale
			.domain([0, d3.max(dataset, d => d[1])])
			.range([svg_h - padding, padding]);
		let r_scale = d3.scale.linear();
		r_scale.domain([0, d3.max(dataset, d => d[1])]).range([2, 5]);

		let svg = d3
			.select("body")
			.append("svg")
			.attr("width", svg_w)
			.attr("height", svg_h);
		let circle1 = svg
			.selectAll("circle")
			.data(dataset)
			.enter()
			.append("circle");
		circle1
			.attr("cx", d => x_scale(d[0]))
			.attr("cy", d => y_scale(d[1]))
			.attr("r", d => r_scale(d[1]));
		let tx = svg
			.selectAll("text")
			.data(dataset)
			.enter()
			.append("text");
		tx.text(d => d[0] + "," + d[1])
			.attr("x", d => x_scale(d[0]))
			.attr("y", d => y_scale(d[1]))
			.attr("class", "advanced_text");

		let x_axis = d3
			.svg
			.axis()
			.scale(x_scale)
			.orient("bottom")
			.ticks(5);
		svg
			.append("g")
			.attr("class", "axis")
			.attr("transform", "translate(0," + (svg_h - padding) + ")")
			.call(x_axis);
		let y_axis = d3
			.svg
			.axis()
			.scale(y_scale)
			.orient("left")
			.ticks(5);
		svg
			.append("g")
			.attr("class", "axis")
			.attr("transform", "translate(" + padding + ",0)").call(y_axis);
	}

	function non_scale() {
		let svg_h = 100, random_data = [];
		for (let i = 0; i < 25; i++) {
			random_data.push(Math.random() * 30);
		}

		d3.select("body")
			.selectAll("p")
			.data(DATASET1)
			.enter()
			.append("p")
			.text(d => d*2)
			.style("color", d => d > 15 ? "red" : "black");
		d3.select("body")
			.selectAll("div")
			.data(DATASET1)
			.enter()
			.append("div")
			.attr("class", "graph")
			.style("height", d => d*5 + "px");

		let svg_c = d3
			.select("body")
			.append("div")
			.append("svg")
			.attr("width", svg_w)
			.attr("height", svg_h);
		let circle = svg_c
			.selectAll("circle")
			.data(DATASET1)
			.enter()
			.append("circle");
		circle
			.attr("cx", (d,i) => (i*50)+25)
			.attr("cy", svg_h/2)
			.attr("r", d => d)
			.attr("class", "sample_circle");

		let svg_r = d3
			.select("body")
			.append("div")
			.append("svg");
		svg_r
			.attr("width", svg_w)
			.attr("height", svg_h);
		let rect = svg_r
			.selectAll("rect")
			.data(DATASET1)
			.enter()
			.append("rect");
		rect
			.attr("x", (d,i) => i*(svg_w/DATASET1.length))
			.attr("y", d => svg_h - d*4)
			.attr("width", (d,i) => svg_w/DATASET1.length - bar_padding)
			.attr("height", d => d*4)
			.attr("fill", d => "rgb(0,0,"+(d*10)+")");
		let text_svg = svg_r
			.selectAll("text")
			.data(DATASET1)
			.enter()
			.append("text");
		text_svg
			.text(d => d)
			.attr(
				"x",
				(d,i) => i*(svg_w/DATASET1.length)
					+ (svg_w/DATASET1.length - bar_padding)/2)
			.attr("y", d => svg_h - d*4 + 15).attr("class", "sample_text");
	}
}());
