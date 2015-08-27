<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    <div class="modal fade login-modal" tabindex="-1" role="dialog" id="relogin">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title text-center">登录</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                        <span class="input-group-addon"><span
							class="glyphicon glyphicon-user"></span></span>
                        <input type="text" class="form-control" name="to_username" id="username" placeholder="username">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon"><span
							class="glyphicon glyphicon-lock"></span></span>
                        <input type="password" class="form-control" name="to_password" id="password" placeholder="password">
                    </div>
                    <div class="alert alert-danger" style="display:none" role="alert" id="errorMsg"></div>
                    <div class="checkbox btn-re">
                        <label>
                            <input type="checkbox"> Remeber me
                        </label>
                    </div>
                    <div class="bttons">
                        <a class="btn btn-primary btn-block" type="submit" onclick="consumerlogin()">Login</a> <a class="btn btn-success btn-block" href="register.html">Register</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
