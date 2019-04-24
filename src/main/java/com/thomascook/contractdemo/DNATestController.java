package com.thomascook.contractdemo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DNATestController {

    @PostMapping(value = "/dna-test")
    public ResultResponse dnaTest(@RequestBody PersonDTO person) {
        if (EnumUtils.isValidEnumIgnoreCase(SimpsonFamily.class, person.getName())) {
            SimpsonFamily simpson = EnumUtils.getEnumIgnoreCase(SimpsonFamily.class, person.getName());
            return new ResultResponse(person.getName(), simpson.getAge(), true);
        }
        return new ResultResponse(person.getName(), null, false);
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    enum SimpsonFamily {
        HOMER(40),
        BART(12),
        MARGE(38),
        LISA(10),
        MAGGIE(1);

        private final Integer age;
    }

}
