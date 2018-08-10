
	function add_item() {
		if ($("#addRole").children().length == 2) {
			alert("생성할 수 없습니다.");
		} else {
			var div = document.createElement('div');
			div.innerHTML = '<hr class="my_hr">'
					+ document.getElementById('role').innerHTML;
			document.getElementById('addRole').appendChild(div);
		}
	}

	function remove_item(obj) {
		if (obj.parentNode.parentNode.parentNode.id == 'role') {
			alert("삭제할 수 없습니다.");
		} else {
			obj.parentNode.parentNode.parentNode.remove();
		}
	}

	function add_interview() {
		if ($("#addInterview").children().length == 2) {
			alert("생성할 수 없습니다.");
		} else {
			var div = document.createElement('div');
			div.innerHTML = '<hr class="my_hr">'
					+ document.getElementById('interview').innerHTML;
			document.getElementById('addInterview').appendChild(div);
		}
	}

	function remove_interview(obj) {
		if (obj.parentNode.parentNode.parentNode.id == 'interview') {
			alert("삭제할 수 없습니다.");
		} else {
			obj.parentNode.parentNode.parentNode.remove();
		}
	}

	function add_faq() {
		if ($("#addFaq").children().length == 2) {
			alert("생성할 수 없습니다.");
		} else {
			var div = document.createElement('div');
			div.innerHTML = '<hr class="my_hr">'
					+ document.getElementById('faq').innerHTML;
			document.getElementById('addFaq').appendChild(div);
		}
	}

	function remove_faq(obj) {
		if (obj.parentNode.parentNode.parentNode.id == 'faq') {
			alert("삭제할 수 없습니다.");
		} else {
			obj.parentNode.parentNode.parentNode.remove();
		}
	}
	