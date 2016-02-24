(function() {
	"use strict";
	
	non_scale();
	
	function non_scale() {
		const DATASET1 = [ 1, 5, 10, 15, 20, 25  ],
		DATASET2 = [
		            [5, 20], [480, 90], [250, 50], [100, 33], [330, 95],
		            [410, 12], [475, 44], [25, 67], [85, 21], [220, 88]
		            ], svg_w = 500, svg_h = 100, bar_padding = 1;
		let random_data = [];
		for (let i = 0; i < 25; i++) {
			random_data.push(Math.random() * 30);
		}
		
		d3.select("body").selectAll("p").data(DATASET1).enter().append("p")
		.text(d => d*2).style("color", d => d > 15 ? "red" : "black");
		d3.select("body").selectAll("div").data(DATASET1).enter().append("div")
		.attr("class", "graph").style("height", d => d*5 + "px");
		
		let svg_c = d3.select("body").append("div").append("svg").attr("width", svg_w).attr("height", svg_h);
		let circle = svg_c.selectAll("circle").data(DATASET1).enter().append("circle");
		circle.attr("cx", (d,i) => (i*50)+25).attr("cy", svg_h/2).attr("r", d => d).attr("class", "sample_circle");
		
		let svg_r = d3.select("body").append("div").append("svg");
		svg_r.attr("width", svg_w).attr("height", svg_h);
		let rect = svg_r.selectAll("rect").data(DATASET1).enter().append("rect");
		rect.attr("x", (d,i) => i*(svg_w/DATASET1.length)).attr("y", d => svg_h - d*4)
		.attr("width", (d,i) => svg_w/DATASET1.length - bar_padding).attr("height", d => d*4)
		.attr("fill", d => "rgb(0,0,"+(d*10)+")");
		let text_svg = svg_r.selectAll("text").data(DATASET1).enter().append("text");
		text_svg.text(d => d)
		.attr("x", (d,i) => i*(svg_w/DATASET1.length) + (svg_w/DATASET1.length - bar_padding)/2)
		.attr("y", d => svg_h - d*4 + 15).attr("class", "sample_text");
		
		let svg = d3.select("body").append("svg").attr("width", svg_w).attr("height", svg_h);
		let circle1 = svg.selectAll("circle").data(DATASET2).enter().append("circle");
		circle1.attr("cx", d => d[0]).attr("cy", d => d[1]).attr("r", d => Math.sqrt(svg_h - d[1]));
		let tx = svg.selectAll("text").data(DATASET2).enter().append("text");
		tx.text(d => d[0] + "," + d[1]).attr("x", d => d[0]).attr("y", d => d[1]).attr("class", "advanced_text");
	}
}());
