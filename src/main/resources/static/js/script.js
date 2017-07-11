$(document).ready(
		function() {
			$("#createButton").click(function() {
				entityName = $("#entityName").val();
				$("#modal-content").load(entityName + "/create");
			});

			$(".editButton").click(
					function() {
						entityName = $("#entityName").val();
						$("#modal-content").load(
								entityName
										+ "/"
										+ $(this).attr(
												"data-" + entityName + "Id")
										+ "/edit");
					});

		});