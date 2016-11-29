<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript"
	src="js/currentHoldings/currentHoldings.js"></script>

<div class="container">
	<div class="main">
		<div class="shoping_bag">
			<h4>
				<img src="images/bag1.png">my current holdings
			</h4>
			<div class="clearfix"></div>
		</div>
		<s:iterator value="context.currentHoldingsProjectorOBs">

			<div
				id="holding<s:property value='currentHoldingsDBBean.holdingid'/>">

				<div class="shoping_bag1">
					<div class="shoping_left">
						<div class="shoping1_of_1">
							<img src="<s:property value="imagesDBBean.imagepath"/>"
								class="img-responsive" alt="" />
						</div>
						<div class="shoping1_of_2">
							<h4>
								<a
									href="viewProduct.action?productId=<s:property value="currentHoldingsDBBean.productid"/>"><s:property
										value="productsDBBean.productname" /></a>
							</h4>
							<s:if test="currentHoldingsDBBean.status.equals('ONGOING') || currentHoldingsDBBean.status.equals('UPCOMING')">
								<input
									onclick="endRent(<s:property value='currentHoldingsDBBean.holdingid'/>)"
									type="button" value="End Rent">
							</s:if>
							<s:if
								test="(currentHoldingsDBBean.status.equals('ONGOING') || currentHoldingsDBBean.status.equals('UPCOMING'))
											&& !currentHoldingsDBBean.autorenew">
								<input
									id="enableAutoRenewId<s:property value='currentHoldingsDBBean.holdingid'/>"
									onclick="enableAutoRenew(<s:property value='currentHoldingsDBBean.holdingid'/>)"
									type="button" value="Enable AutoRenew">
								<input
									id="disableAutoRenewId<s:property value='currentHoldingsDBBean.holdingid'/>"
									onclick="disableAutoRenew(<s:property value='currentHoldingsDBBean.holdingid'/>)"
									type="button" value="Disable AutoRenew" style="display: none">
							</s:if>
							<s:if
								test="(currentHoldingsDBBean.status.equals('ONGOING') || currentHoldingsDBBean.status.equals('UPCOMING')) 
											&& currentHoldingsDBBean.autorenew">
								<input
									id="disableAutoRenewId<s:property value='currentHoldingsDBBean.holdingid'/>"
									onclick="disableAutoRenew(<s:property value='currentHoldingsDBBean.holdingid'/>)"
									type="button" value="Disable AutoRenew">
								<input
									id="enableAutoRenewId<s:property value='currentHoldingsDBBean.holdingid'/>"
									onclick="enableAutoRenew(<s:property value='currentHoldingsDBBean.holdingid'/>)"
									type="button" value="Enable AutoRenew" style="display: none">
							</s:if>

						</div>
						<div class="clearfix"></div>
					</div>
					<div class="shoping_right">
						<p>
							Security Money<span><s:property
									value="productsDBBean.securitymoney" /></span>
						</p>
						<p>
							Rent Offer<span> Rs. <s:property
									value="rentOffersDBBean.amount" /> For <s:property
									value="rentOffersDBBean.periodvalue" /> <s:property
									value="rentOffersDBBean.periodunit" /></span>
						</p>
						<p>
							Expiry Date<span><s:property
									value="currentHoldingsDBBean.rentexpirydate" /></span>
						</p>
						<p>
							Status <span><s:property
									value="currentHoldingsDBBean.status" /></span>
						</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</s:iterator>
	</div>

</div>

</html>
