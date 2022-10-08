def text_to_vig(text: str, key: [], alphalist: []):
    return encode_or_decode_text(text, key, alphalist, 'encode')


def vig_to_text(text: str, key: [], alphalist: []):
    return encode_or_decode_text(text, key, alphalist, 'decode')


def encode_or_decode_text(text: str, key: [], alphalist: [], operation: str):
    encode: str = ''
    index: int = 0
    index_key: int = 0

    for i, value in enumerate(text):

        for j, val in enumerate(alphalist):
            if value == val:
                index = j

        if index_key >= len(key):
            index_key = index_key - len(key)

        if operation == "encode":
            nouvel_index = update_index_inside_bounds(index + key[index_key], alphalist)
        else:
            nouvel_index = update_index_inside_bounds(index - key[index_key], alphalist)

        encode = encode + alphalist[nouvel_index]
        index_key = index_key + 1
    return encode


def update_index_inside_bounds(nouveau_indice: int, alphalist: []):
    if 0 < nouveau_indice < len(alphalist):
        return nouveau_indice
    elif nouveau_indice > len(alphalist):
        nouveau_indice = nouveau_indice - len(alphalist)
        return update_index_inside_bounds(nouveau_indice, alphalist)
    elif nouveau_indice < 0:
        nouveau_indice = nouveau_indice + len(alphalist)
        return update_index_inside_bounds(nouveau_indice, alphalist)
    else:
        return nouveau_indice


def file_to_vig(key: [], alphalist: []):
    with open('files/vigenere.txt', 'r') as myFile:
        contenu = myFile.readline()
    contenu = text_to_vig(contenu, key, alphalist)
    with open('files/vigenere_code.txt', 'w') as fileWritter:
        fileWritter.write(contenu)


def vig_to_file(key: [], alphalist: []):
    with open('files/vigenere_code.txt', 'r') as myFile:
        contenu = myFile.readline()
    contenu = vig_to_text(contenu, key, alphalist)
    with open('files/vigenere_decode.txt', 'w') as fileWritter:
        fileWritter.write(contenu)


alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z']

if __name__ == '__main__':
    file_to_vig([1, 3, 2], alphabet)
