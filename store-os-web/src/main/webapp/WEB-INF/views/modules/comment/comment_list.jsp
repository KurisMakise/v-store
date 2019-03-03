<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户评价</title>
<link rel="stylesheet" href="${ctxsta}/os/css/goods-comment.css">
</head>
<body>
<!-- 轮播top菜单导航引入 -->
<jsp:include page="/WEB-INF/views/modules/common/site_header.jsp" />
<!-- 轮播top菜单导航引入 --> 

<!--     分类导航栏 begin       -->
<div class="breadcrumbs">
  <div class="container-fluid"><a href='${ctx}/index'>首页</a>
    <c:forEach items="${upperCategories}" var="upperCategory"><span class="sep">&gt;</span><a href="${ctx}/list?categoryId=${upperCategory.categoryId}">${upperCategory.name}</a></c:forEach>
    <span class="sep">&gt;</span><a href="${ctx}/detail/${product.productNumber}">${product.name}</a> </div>
</div>
<!--     分类导航栏 end       --> 

<!--     商品评论 begin       -->
<div class="goods-comment">
  <div class="goods-comment-groom" id="J_recommendComment" style="display:${productAttribute.commentNumber eq 0?'none':'black'}">
    <div class="container-fluid">
      <ul class="main-block">
        <li class="percent">
          <div class="per-num"> <i>${productAttribute.commentAverage}</i>% </div>
          <div class="per-title"> 购买后满意 </div>
          <div class="per-amount"> <i>${productAttribute.commentNumber}</i>名用户投票 </div>
        </li>
      </ul>
    </div>
  </div>
  <div class="goods-comment-order-block" id="J_commentOrder">
    <div class="container-fluid">
      <div class="row">
        <div class="span14">
          <div class="left-title J_commentOrder"> <a href="${ctx}/comment/list?productNumber=${product.productNumber}&sort=1" class="${sort eq 1 ? 'current':''} J_helpOrder">最有帮助的评价</a> <span class="sep">|</span> <a href="${ctx}/comment/list?productNumber=${product.productNumber}&sort=0"  class="${sort eq 0 ? 'current':''}">最新的评价</a> </div>
        </div>
      </div>
    </div>
  </div>
  <div class="goods-comment-list-detail-block">
    <div class="container-fluid">
      <div class="row">
        <div class="span14 goods-comment-list-detail">
          <ul class="comment-box-list" id="J_supComment">
            <c:forEach items="${commentVOs}" var="comment">
              <li class="" data-id="${comment.commentId}">
                <div class="user-image"> <img src="${ctximg}/${comment.picImg}" alt="${comment.userName}"> </div>
                <div class="user-emoj">&nbsp;超爱&nbsp;<i class="glyphicon glyphicon-thumbs-up"></i> </div>
                <div class="user-name-info"> <span class="user-name"> ${comment.userName} </span> <span class="user-time"><fmt:formatDate value="${comment.createTime}" pattern="yyyy年MM月dd日" /></span> <span class="pro-info">蓝色</span> </div>
                <div class="user-hand-block"> <a href="javascript:void(0);" data-commentid="${comment.commentId}" class="J_hasHelp" onclick="comment_like(this,${comment.commentId})"><i class="glyphicon glyphicon-thumbs-up"></i>&nbsp;赞&nbsp;<span class="amount"> ${comment.goodCount}</span></a> </div>
                <dl class="user-comment">
                  <dt class="user-comment-content J_commentContent">
                    <p class="content-detail"><a href="" target="_blank">${comment.content}</a></p>
                  </dt>
                  <dd class="user-comment-self-input">
                    <div class="input-block">
                      <input type="text" placeholder="回复楼主" class="J_commentAnswerInput">
                      <a href="javascript:void(0);" class="btn  answer-btn J_commentAnswerBtn" data-commentid="${comment.commentId}" onclick="comment_reply(this,${comment.commentId})">回复</a> </div>
                  </dd>
                  <c:forEach items="${comment.commentReplies}" var="commentReply">
                    <c:if test="${commentReply.type eq 1}">
                      <dd class="user-comment-answer"> <img class="self-image" src="${ctximg}/${commentReply.picImg}" alt="${commentReply.userName}">
                        <p>${commentReply.content}<span class="official-name">&nbsp;&nbsp;官方回复&nbsp;</span> <a href="javascript:void(0);" class="J_csLike" data-commentid="${commentReply.commentReplyId}" onclick="comment_csLike(this,${commentReply.commentReplyId})"> <i class="glyphicon glyphicon-thumbs-up"></i>&nbsp;赞客服&nbsp; <span class="amount">${commentReply.goodCount}</span> </a></p>
                      </dd>
                    </c:if>
                    <c:if test="${commentReply.type eq 0}">
                      <dd class="user-comment-answer"> <img class="self-image" src="${ctximg}/${commentReply.picImg}" alt="${commentReply.userName}">
                        <p>${commentReply.content}&nbsp;&nbsp;- <span class="answer-user-name">${commentReply.userName}</span> </p>
                      </dd>
                    </c:if>
                  </c:forEach>
                </dl>
              </li>
            </c:forEach>
          </ul>
          <div class="goods-detail-null-content" style="display:${empty commentVOs ? 'block':'none'}" id="J_commentTipInfo">
            <h3>暂时还没有更多评价</h3>
            <p>期待你分享科技带来的乐趣</p>
          </div>
          <div class="comment-page-nav-list" id="J_commentPagenav">
            <c:if test="${pageInfo.total gt pageInfo.limit and not empty commentVOs}">
              <div id="pager" data-pager-href="${ctx}/comment/list?productNumber=${product.productNumber}&sort=${sort}&page=" data-pager-totalPage="${pageInfo.totalPage}" data-pager-current="${pageInfo.current}"></div>
            </c:if>
          </div>
        </div>
        <div class="span6 goods-detail-info-block">
          <div class="goods-detail-info">
            <div class="goods-img-block"> <a target="_blank" href="${ctx}/item/${product.productNumber}" title="${product.name}"> <img src="${ctximg}/${product.picImg}" class="J_cartBigImg" alt="${product.name}"> </a> </div>
            <div class="goods-name J_cartGoodsName"> ${product.name} </div>
            <div class="goods-price"> <b>${product.showPrice}</b><i>&nbsp;元</i> </div>
          </div>
          <div class="goods-cart-btn-block" id="J_cartBtnBlock"> <a target="_blank" href="${ctx}/detail/${product.productNumber}" class="btn btn-primary goods-add-cart-btn">加入购物车</a> </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--     商品评论 end       -->

<myfooter> 
  <!-- 分页js --> 
  <script src="${ctxsta}/common/pager/jquery.pager.js"></script> 
  <!-- layer javascript --> 
  <script src="${ctxsta}/common/layer/layer.js"></script> 
  <script type="text/javascript">
  	var pagecount = $('#pager').attr('data-pager-totalPage'); // 总页面数
  	var current = $('#pager').attr('data-pager-current'); // 当前页数
  	var href = $('#pager').attr('data-pager-href'); // 链接地址
  	$(document).ready(function() {
  		$("#pager").pager({
  			pagenumber : current,
  			pagecount : pagecount,
  			buttonClickCallback : PageClick
  		});
  	});
  	PageClick = function(number) {
  		$("#pager").pager({
  			pagenumber : number,
  			pagecount : pagecount,
  			buttonClickCallback : PageClick
  		});
  		window.location.href = href + number;
  	}
	/**
	 * input 聚焦事件
	 */
	$(function() {
		$(" input[ type='text' ] ").focus(function() {
			$(this).parent().parent().addClass('showIn');
		});
		$(" input[ type='text' ] ").blur(function() {
			$(this).parent().parent().removeClass('showIn');
		});
	});
	/**
	 * 随机分配评论颜色（最有帮助）
	 */
	$(function() {
		var $elements = $('#J_supComment').children('li');
		var len = $elements.length;
		// alert('有 ' + len + ' 个相同class');
		$elements.each(function() {
			var $this = $(this);
			var num = (Math.floor(Math.random() * 10) + 1); //输出1-10的随机数搜索
			$this.addClass('item-rainbow-' + num);
		});
	})
	
	/**
	 * 商品评论点赞
	 */
	function comment_like(obj, commentId) {
		var data = {};
		data.commentId = commentId;
		$.ajax({
			type : 'put',
			dataType : 'json',
			data : data,
			url : baselocation + '/comment/like',
			success : function(result) {
				if (result.code == 1) {
					$(obj).addClass("current");
					$(obj).children(".amount").text(result.data);
				} else if (result.code == 401) {
					window.location.href = baselocation + '/pass/login';
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	}
	
	/**
	 * 客服评论点赞
	 */
	function comment_csLike(obj, commentReplyId) {
		var data = {};
		data.commentReplyId = commentReplyId;
		$.ajax({
			type : 'put',
			dataType : 'json',
			data : data,
			url : baselocation + '/comment/csLike',
			success : function(result) {
				if (result.code == 1) {
					$(obj).addClass("current");
					$(obj).children(".amount").text(result.data);
				} else if (result.code == 401) {
					window.location.href = baselocation + '/pass/login';
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	}
	
	/**
	 * 评论回复
	 */
	function comment_reply(obj, commentId) {
		var data = {};
		data.commentId = commentId;
		data.content = $(obj).prev().val();
		$.ajax({
			type : 'post',
			dataType : 'json',
			data : data,
			url : baselocation + '/comment/reply',
			success : function(result) {
				if (result.code == 1) {
					layer.msg('发表问题成功!', {
						icon : 1,
						time : 1000
					});
					$(obj).prev().val("");
				} else if (result.code == 401) {
					window.location.href = baselocation + '/pass/login';
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	}	
  </script> 
</myfooter>
</body>
</html>