import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name('I am not Simpson')

    description('''
    when:
	    Received name that related to Simpson family
    then:
	    Indicate that you are Simpson and you age
    ''')

    request {
        method 'POST'
        url '/dna-test'
        body(
                name: $(anyAlphaUnicode())
        )
        bodyMatchers {
            jsonPath('$.name', byRegex('^(?:(?!(homer|lisa|bart|marge|maggie)).)*$'))
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body(
                name: "${fromRequest().body('$.name')}",
                simpson: false
        )
        headers {
            contentType(applicationJson())
        }
    }
}