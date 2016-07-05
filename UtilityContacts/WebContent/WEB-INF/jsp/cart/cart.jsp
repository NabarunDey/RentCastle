<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/cart/cart.js"></script>

<div class="container">
	<div class="main">
		<div class="shoping_bag">
			<h4>
				<img src="images/bag1.png">my shopping bag
			</h4>
			<ul class="s_art">
				<li><span><s:property
							value="context.cartProjectorOB.numberOfItemsInCart" /> Items</span></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<s:iterator value="context.cartProjectorOB.cartItems">

			<div
				id="cart<s:property value='productId'/>-<s:property value='rentId'/>">
				<s:hidden id="productId" value="%{productId}" />
				<s:hidden id="rentOfferId" value="%{rentId}" />

				<div class="shoping_bag1">
					<div class="shoping_left">
						<div class="shoping1_of_1">
							<img src="<s:property value="imageUrl"/>" class="img-responsive"
								alt="" />
						</div>
						<div class="shoping1_of_2">
							<h4>
								<a href="#"><s:property value="productName" /></a>
							</h4>
							<span>qty <b>1</b></span>
							<ul class="s_icons">
								<li><a href="#"
									onclick="removeFromCart(productId.value,rentOfferId.value)"><img
										src="images/s_icon3.png" alt=""> Remove</a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="shoping_right">
						<p>
							Security Money<span><s:property value="securityMoney" /></span>
						</p>
						<p>
							Rent Offer<span> Rs. <s:property value="rentAmount" />
								For <s:property value="periodValue" /> <s:property
									value="periodUnit" /></span>
						</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</s:iterator>
	</div>
	<div class="shoping_bag2">
		<div class="shoping_left">
			<a class="btn1" href="<s:url action='getCartOrderInput'/>">place order</a>
		</div>
		<div class="clearfix"></div>
	</div>
</div>

</html>
