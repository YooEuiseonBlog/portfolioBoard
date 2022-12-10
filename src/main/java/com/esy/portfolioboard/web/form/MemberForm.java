package com.esy.portfolioboard.web.form;

import lombok.*;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberForm {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, max = 30, message = "글자 수가 맞지 않습니다. 다시 입력해주세요.")
    private String username;

    @Email(message = "이메일 양식에 맞게 입력해주세요.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "^01(?:0|1|[6-9])$", message = "형식에 맞게 입력해주세요.")
    private String tel1;
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "^(?:\\d{3}|\\d{4})$", message = "형식에 맞게 입력해주세요.")
    private String tel2;
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "^\\d{4}$", message = "형식에 맞게 입력해주세요.")
    private String tel3;

    // Builder pattern
    @NotBlank
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$\t", message = "전화번호 형식에 맞지 않습니다.")
    private String  tel;

    public MemberForm(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.email = builder.email;
        this.tel1 = builder.tel1;
        this.tel2 = builder.tel2;
        this.tel3 = builder.tel3;
    }

    public static class Builder {
        private String userId;
        private String  username;
        private String email;
        private String tel1;
        private String tel2;
        private String tel3;

        public Builder userId(String userId){
            this.userId = userId;
            return this;
        }
        public Builder username(String  username){
            this.username = username;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder tel1(String tel1){
            this.tel1 = tel1;
            return this;
        }

        public Builder tel2(String tel2){
            this.tel2 = tel2;
            return this;
        }

        public Builder tel3(String tel3){
            this.tel3 = tel3;
            return this;
        }

        public Builder tel(String tel) {
            if (tel != null) {
                String[] strings = tel.split("-");
                this.tel1 = strings[0];
                this.tel2 = strings[1];
                this.tel3 = strings[2];
            }
            return this;
        }
        public MemberForm build(){
            return new MemberForm(this);
        }
    }

    public String getTel(){
        return tel1 + "-" + tel2 + "-" + tel3;
    }



}
