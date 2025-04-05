"""
Created on 6/2/2024 by w45242hy
Last-edit: 1/3/2024 by w45242hy

@author w45242hy
@version 1.0.0 6/2/2024
@version 1.1.0 19/2/2024
@version 1.2.0 2/3/2024

The main programme that invokes functions in WebTester
"""
from web_tester import WebTester
from bs4 import BeautifulSoup

"""
The list containing all the files paths of xml files to be read by web tester
"""
xml_file_paths = []

"""
The file path of the xml file which contains all the testings and details for 1 website
"""
xml_file_path = "xml-docs/web-testing-epublication.xml"
# xml_file_path = "xml-docs/web-testing-testhtmlform.xml"


def read_xml_file_paths():
    """
    Read the xml configuration file "", which contains all the file path for xml files to be read by web tester
    :param: None
    :return: None
    """
    file_path = "xml-docs/web-testing-config.xml"
    with open(file_path, "r") as f:
        file = f.read()

    xml_reader = BeautifulSoup(file, "xml")
    configuration_files = xml_reader.find_all("configuration-file")

    for cf in configuration_files:
        xml_file_paths.append(cf.text)


if __name__ == "__main__":
    # Read web-testing-config.xml
    read_xml_file_paths()

    # Run the code
    # Multiple case
    for xml_file_path in xml_file_paths:
        web_tester = WebTester(xml_file_path)
        web_tester.run()

    # Single case
    # web_tester = WebTester(xml_file_path)
    # web_tester.run()
