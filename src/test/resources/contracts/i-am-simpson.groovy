import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name('I am Simpson')

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
                name: value(regex('(homer|lisa|bart|marge|maggie)'))
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body(
                name: "${fromRequest().body('$.name')}",
                simpson: true,
                age: value(regex(positiveInt()))
        )
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}