<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script>
	$("#testimonialSlide > div:gt(0)").hide();

	setInterval(function() {
		$('#testimonialSlide > div:first').fadeOut(0).next().fadeIn(1500).end()
				.appendTo('#testimonialSlide');
	}, 7000);
</script>

<div class="container">
	<div class="main">

		<div class="content">
			<div class="content_text">
				<br> <br>
				<h2>
					This is what our users have to say about us!
					<div align="right" style="font-size: 20px">
						<a href="<s:url  action='myTestimonial'/>">My Testimonial</a>
					</div>
				</h2>

			</div>

			<div class="row content-row" id="testimonialSlide">

				<div>
					<s:iterator value="onloadTestimonialsOB.testimonialsDBBeans" status="stat">

						<s:if test="(#stat.index % 3 )==0 && #stat.index>1">
				</div>
				<div style="display: none;">
					</s:if>




					<div class="col-sm-4">
						<div class="service">
							<div class="service-thumb-home">
								<a href="#"><img src='<s:property value ="imagePath"/>'
									alt=""></a>
							</div>

							<h4>
								<s:property value="displayName" />
							</h4>
							<p>
								<s:property value="comment" />
							</p>
							<!-- <a class="readmore" href="#">Read More &nbsp;<i
								class="fa fa-angle-right"></i>
							</a> -->
						</div>
					</div>

					</s:iterator>


				</div>
			</div>
		</div>

	</div>

</div>
</div>