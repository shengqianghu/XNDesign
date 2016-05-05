$(document).ready(function () {

	//jquery��Ч������ѡ��ȫѡ��ѡȡ��(�޲��)
	// ȫѡ        
	$(".allselect").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			$(this).attr("checked", true);
			// $(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
		});
		GetCount();
	});

	//��ѡ
	$("#invert").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			if ($(this).attr("checked")) {
				$(this).attr("checked", false);
				//$(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
			} else {
				$(this).attr("checked", true);
				//$(this).next().css({ "background-color": "#3366cc", "color": "#000000" });
			} 
		});
		GetCount();
	});

	//ȡ��
	$("#cancel").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			$(this).attr("checked", false);
			// $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
		});
		GetCount();
	});

	// ���и�ѡ(:checkbox)�����¼�
	$(".gwc_tb2 input[name=newslist]").click(function () {
		if ($(this).attr("checked")) {
			//$(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
		} else {
			// $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
		}
	});

	// ���
	$(".gwc_tb2 input[name=newslist]").click(function () {
		// $("#total2").html() = GetCount($(this));
		GetCount();
		//alert(conts);
	});
});
//******************
function GetCount() {
	var conts = 0;
	var aa = 0;
	$(".gwc_tb2 input[name=newslist]").each(function () {
		if ($(this).attr("checked")) {
			for (var i = 0; i < $(this).length; i++) {
				conts += parseInt($(this).val());
				aa += 1;
			}
		}
	});
	$("#shuliang").text(aa);
	$("#zong1").html((conts).toFixed(2));
	$("#jz1").css("display", "none");
	$("#jz2").css("display", "block");
}