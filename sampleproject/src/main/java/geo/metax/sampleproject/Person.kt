package geo.metax.sampleproject

data class Person(var firstName: String, var lastName: String, var yearOfBirth: Int) {
    val fullName
        get() = "$firstName $lastName"
}