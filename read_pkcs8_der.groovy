import java.security.KeyFactory
import java.security.spec.KeySpec
import java.security.spec.PKCS8EncodedKeySpec

@Grapes(
    @Grab(group='org.bouncycastle', module='bcprov-jdk15on', version='1.52')
)

def keyFile = new File("key.pkcs8.der")

KeyFactory keyFactory = KeyFactory.getInstance("RSA")
KeySpec keySpec = new PKCS8EncodedKeySpec(keyFile.bytes)

def privateKey = keyFactory.generatePrivate(keySpec)

println keyFile.absolutePath
println "Private key algorithm: $privateKey.algorithm"
println "Private key format:    $privateKey.format"

